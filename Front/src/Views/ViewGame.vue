<template>
  <div>
    <AppGameHeader :pDificulty="dificulty"/>
    <v-container fluid>
      <v-row align='center' justify='space-around'>
        <AppGameCard 
          v-for="card in cards" :key="card.id"
          :pCard="card"
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
      dificulty: {id: 1, name: 'Fácil', cardQuantity: 6, timeLimit: 120},
      cards: [
        {id: 1, name: 'gato', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
        {id: 2, name: 'gato2', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
        {id: 3, name: 'gato3', image: 'gato-frente.jpg', sound: 'gato-som.mp3'},
      ]
    }
  },
  mounted() {
    //TODO: Mostrar Botão de inicio da partida
  }

};
</script>

<style>

</style>