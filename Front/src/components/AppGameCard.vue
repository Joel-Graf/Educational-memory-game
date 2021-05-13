<template>
  <v-card
    elevation="5"
    class="mx-auto my-6"
    max-width="374"
  >
    <v-card-title class="d-flex justify-space-between text-uppercase font-weight-medium">
      <span>({{card.id}})</span> 
      <span>{{card.name}}</span>
    </v-card-title>

    <v-img
      height="350"
      class="mx-3"
      :src="require(`@/assets/${card.image}`)"
    ></v-img>

    <v-card-actions class="d-flex justify-space-around">
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="playSound"
      >
        Ouvir
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="openAnimalView"
      >
        Detalhes
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
  export default {
    props: {
      pCard: {
        type: Object,
        required: true
      }
    },
    data() {
      return {
        card: this.pCard
      }
    },

    methods: {
      playSound() {
        //TODO: Implementar bloqueio para SPAM
        var audio = new Audio(require(`@/assets/${this.card.sound}`));
        audio.play();
      },
    },
  }
</script>
