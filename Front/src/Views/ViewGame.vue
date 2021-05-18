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
        {id: 1, name: 'gato', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
        {id: 2, name: 'gato2', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
        {id: 3, name: 'gato3', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
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

        if (this.cardsFliped.length == 2) {
          this.isGameLocked = true
          let vueInst = this
          setTimeout(function(){ 
            vueInst.$refs.CardsComponents.forEach((card) => {
              card.isFliped = false
            })
            vueInst.cardsFliped = []
            vueInst.isGameLocked = false
          }, 1500);
        }
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