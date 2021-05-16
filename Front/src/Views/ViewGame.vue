<template>
  <div>
    <AppGameHeader :pDificulty="dificulty" :pLevel='level'/>
    <v-container fluid>
      <v-row align='center' justify='space-around'>
        <AppGameCard 
          v-for="(card, index) in cards" :key="card.id"
          :pCard="card" :pIndex="index" :pCardsFliped="cardsFliped" :pIsGameLocked="isGameLocked" 
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
    //FIXME: Verificar como sincronizar o lock
    handleFlipCard(cardObject) {
      if(!this.isGameLocked) {
        // Adiciona a lista de cartas viradas
        this.cardsFliped.push(cardObject)

        // Caso exista 2 cartas na lista
        // a) Se o ID bate é um match e deve excluir as cartas do jogo
        // b) Se o ID não bate é erro e deve desflipar
        if (this.cardsFliped.length == 2) {
          this.isGameLocked = true
          let vueInst = this
          setTimeout(function(){ 
            vueInst.$refs.CardsComponents.forEach((card) => {
              card.isFliped = false
            })
            vueInst.cardsFliped = []
            vueInst.isGameLocked = false
          }, 1000);
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