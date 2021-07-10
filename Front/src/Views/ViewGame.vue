s<template>
  <div>
    <v-overlay :value="!isGameStarted" :absolute="true">
      <v-btn
        @click="isGameStarted = !isGameStarted"
        :disabled="!isCardsReady"
        color="primary"
        x-large
      >
        Iniciar Jogo
      </v-btn>
    </v-overlay>
    <AppGameHeader
      :Dificulty="dificulty"
      :Level="level"
      :TimerEnabled="isGameStarted && !isGameFinished"
      :CardPairsRemaining="cardPairsRemaining"
      :InitialCards="dificulty.qtd_cartas"
      @timeout="gameResult = 'Derrota'"
    />
    <v-container class="interface" fluid>
      <v-row v-if="!isGameFinished" align="center" class="cards">
        <AppGameCard
          v-for="(card, index) in cards"
          :key="index+'_'+card.nome"
          :Card="card"
          :LevelName="level.nome"
          :height="324"
          :width="332"
          :Index="index"
          :CardsFliped="cardsFliped"
          :IsGameLocked="isGameLocked"
          :Dificulty="dificulty.nome"
          @flip-card="handleFlipCard"
          ref="CardsComponents"
        />
      </v-row>
      <AppGameFinished
        :GameResult="gameResult"
        align="center"
        v-else
      />
    </v-container>
  </div>
</template>

<script>
import AppGameFinished from "../components/AppGameFinished.vue";
import AppGameHeader from "../components/AppGameHeader.vue";
import AppGameCard from "../components/AppGameCard.vue";

export default {
  components: {
    AppGameFinished,
    AppGameHeader,
    AppGameCard,
  },
  data() {
    return {
      level: this.$store.state.level,
      dificulty: this.$store.state.dificuldade,
      isGameLocked: false,
      gameResult: "",
      cardsFliped: [],
      isGameStarted: false,
      isCardsReady: false,
      cards: [],
    };
  },
  computed: {
    cardPairsRemaining() {
      return this.cards.length / 2;
    },
    isGameFinished() {
      return this.gameResult != "";
    },
  },
  watch: {
    cardPairsRemaining(newCardsRemaning) {
      if (newCardsRemaning == 0) {
        this.gameResult = "Vitória";
      }
    }
  },
  methods: {
    handleFlipCard(cardObject) {
      //Verifica se o jogo está trancado (Existe duas cartas viradas)
      if (!this.isGameLocked) {
        // Adiciona a lista de cartas viradas
        this.cardsFliped.push(cardObject);

        // Trava o jogo quando se tem duas cartas viradas
        if (this.cardsFliped.length == 2) {
          this.isGameLocked = true;

          // Verifica se fechou o par ou nãos
          let vueInst = this;
          setTimeout(function() {
            var card1 = vueInst.cardsFliped[0];
            var card2 = vueInst.cardsFliped[1];
            
            if (card1.id == card2.id) {
              // Se fechou par, deleta as cartas
              vueInst.deleteCards(card1, card2);
            } else {
              // Se não fechou, desvira as cartas
              vueInst.$refs.CardsComponents[card1.index].isFliped = false;
              vueInst.$refs.CardsComponents[card2.index].isFliped = false;
            }

            // Limpa a lista de cartas viradas e destrava o jogo
            vueInst.cardsFliped = [];
            vueInst.isGameLocked = false;
          }, 1500);
        }
      }
    },
    deleteCards(card1, card2) {
      // Workaround pra poder deletar via indice
      if (card1.index > card2.index) {
        this.$delete(this.cards, card1.index);
        this.$delete(this.cards, card2.index);
      } else {
        this.$delete(this.cards, card2.index);
        this.$delete(this.cards, card1.index);
      }
    },
    shuffle(array) {
      var currentIndex = array.length,  randomIndex;
      // While there remain elements to shuffle...
      while (0 !== currentIndex) {
        // Pick a remaining element...
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex--;
        // And swap it with the current element.
        [array[currentIndex], array[randomIndex]] = [
          array[randomIndex], array[currentIndex]];
      }
      return array;
    }
  },
  mounted() {
    var opts = {
      idBioma: this.$store.state.level.id,
      quantidadeCartas: this.$store.state.dificuldade.qtd_cartas / 2,
    };
    fetch("http://localhost:8090/pac3/animais", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(opts),
    })
      .then((response) => {
        if (response.status !== 200) {
          console.log("Request Error! Status: " + response.status);
          return;
        }
        response.json().then((resReq) => {
          var arrCards = resReq.reduce(function (res, current) {
            return res.concat([current, current]);
          }, []);
          arrCards = this.shuffle(arrCards)
          this.cards = arrCards
          setTimeout(()=>{this.isCardsReady = true}, 1000)
        });
      })
      .catch((error) => {
        console.log("Fetch Error! " + error);
      });
  },
};
</script>

<style>
.cards {
  padding: 15px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
</style>
