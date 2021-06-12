<template>
  <div>
    <v-overlay :value="!isGameStarted" absolute="true">
      <v-btn @click="isGameStarted = !isGameStarted" color="primary" x-large>
        Iniciar Jogo
      </v-btn>
    </v-overlay>
    <AppGameHeader
      :Dificulty="dificulty"
      :Level="level"
      :TimerEnabled="isGameStarted && !isGameFinished"
      :CardPairsRemaining="cards.length"
      :InitialCards="dificulty.cardQuantity"
      @timeout="gameResult = 'Derrota'"
    />
    <v-container fluid>
      <v-row v-if="!isGameFinished" align="center" justify="space-around">
        <AppGameCard
          v-for="(card, index) in cards"
          :key="card.id"
          :Card="card"
          :height="324"
          :width="332"
          :Index="index"
          :CardsFliped="cardsFliped"
          :IsGameLocked="isGameLocked"
          @flip-card="handleFlipCard"
          ref="CardsComponents"
        />
      </v-row>
      <AppGameFinished :GameResult="gameResult" align="center" v-else/>
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
      level: "Floresta",
      dificulty: { id: 1, name: "Fácil", cardQuantity: 8, timeLimit: 10 },
      cards: [
        {
          id: 1,
          animalId: 1,
          name: "gato",
          image: "gato-frente.jpg",
          sound: "gato-som.mp3",
        },
        {
          id: 2,
          animalId: 2,
          name: "gato2",
          image: "gato-frente.jpg",
          sound: "gato-som.mp3",
        },
        {
          id: 3,
          animalId: 2,
          name: "gato3",
          image: "gato-frente.jpg",
          sound: "gato-som.mp3",
        },
        {
          id: 4,
          animalId: 1,
          name: "gato",
          image: "gato-frente.jpg",
          sound: "gato-som.mp3",
        },

      ],
      isGameLocked: false,
      gameResult: "",
      cardsFliped: [],
      isGameStarted: false,
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
    },
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
            if (card1.animalId == card2.animalId) {
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
  },
};
</script>

<style></style>
