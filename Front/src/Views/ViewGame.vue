<template>
  <div>
    <AppGameHeader :pDificulty="dificulty" :pLevel='level'/>
    <v-container fluid>
      <v-row align='center' justify='space-around'>
        <AppGameCard 
          v-for="(card, index) in cards" :key="card.id"
          :Card="card" :Index="index" :CardsFliped="cardsFliped" 
          :IsGameLocked="isGameLocked"
          @flip-card="handleFlipCard" 
          ref="CardsComponents"
        />
      </v-row>
    </v-container>
  </div>
</template>

<script>
import AppGameHeader from '../components/AppGameHeader.vue';
import AppGameCard from '../components/AppGameCard.vue';

export default {
  components: {
    AppGameCard,
    AppGameHeader,
  },

  data() {
    return {
      level: 'Floresta',
      dificulty: {id: 1, name: 'Fácil', cardQuantity: 6, timeLimit: 120},
      cards: [
        {id: 1, animalId: 1, name: 'gato', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
        {id: 2, animalId: 2, name: 'gato2', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
        {id: 3, animalId: 2, name: 'gato3', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
        {id: 4, animalId: 1, name: 'gato', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
      ],
      isGameLocked: false,
      cardsFliped: []
    }
  },
  methods: {

    handleFlipCard(cardObject) {
      //Verifica se o jogo está trancado (Existe duas cartas viradas)
      if(!this.isGameLocked) {

        // Adiciona a lista de cartas viradas
        this.cardsFliped.push(cardObject)

        // Trava o jogo quando se tem duas cartas viradas
        if (this.cardsFliped.length == 2) {
          this.isGameLocked = true

          // Verifica se fechou o par ou nãos
          let vueInst = this
          setTimeout(function(){ 
            var card1 = vueInst.cardsFliped[0]
            var card2 = vueInst.cardsFliped[1]
            if(card1.animalId == card2.animalId) {
              // Se fechou par, deleta as cartas
              vueInst.deleteCards(card1, card2)
            } else {
              // Se não fechou, desvira as cartas
              vueInst.$refs.CardsComponents[card1.index].isFliped = false
              vueInst.$refs.CardsComponents[card2.index].isFliped = false
            }

            // Limpa a lista de cartas viradas e destrava o jogo
            vueInst.cardsFliped = []
            vueInst.isGameLocked = false
          }, 1500);
        }
      }
    }, 
    deleteCards(card1, card2) {
      // Workaround pra poder deletar via indice
      if(card1.index > card2.index) {
        this.$delete(this.cards, card1.index)
        this.$delete(this.cards, card2.index)
      } else {
        this.$delete(this.cards, card2.index)
        this.$delete(this.cards, card1.index)
      }
    }
  },
  mounted() {
    //TODO: Mostrar tela de loading até montar tudo, depois mostrar o botão
    //TODO: Mostrar Botão de inicio da partida
  }
};
</script>

<style>

</style>