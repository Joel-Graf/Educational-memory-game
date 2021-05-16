<template>
  <v-card
    elevation="5"
    class="mx-auto my-6"
    width="324"
    height="332"
    @click="clickCard"
  >
    <transition name="slide-fade">
      <div v-if='isFliped'>
        <v-card-title class="d-flex justify-space-between text-uppercase font-weight-medium">
          <span>({{card.id}})</span> 
          <span>{{card.name}}</span>
        </v-card-title>

        <v-img
          height="260"
          class="mx-3 mb-2"
          :src="require(`@/assets/${card.image}`)"
        ></v-img>
      </div>
      <div v-else>
        <!-- TODO: Adicionar Fundo da carta -->
      </div>
    </transition>
  </v-card>
</template>

<script>
  export default {
    props: {
      pCard: {
        type: Object,
        required: true
      },
      pIndex: {
        type: Number,
        required: true
      },
      pCardsFliped: {
        type: Array,
        required: true
      },
      pIsGameLocked: {
        type: Boolean,
        required: true
      }
    },
    data() {
      return {
        card: this.pCard,
        index: this.pIndex,
        cardsFliped: this.pCardsFliped,
        isGameLocked: this.pIsGameLocked,
        isFliped: false
      }
    },
    methods: {
      playSound() {
        //TODO: Implementar bloqueio para SPAM
        var audio = new Audio(require(`@/assets/${this.card.sound}`));
        audio.play();
      },
      clickCard() {
        console.log(this.isGameLocked)
        if(this.isFliped || this.isGameLocked) {
          //TODO: Carta já virada ou jogo trancado, rodar animação de erro
        } else {
          this.isFliped = true
          this.$emit('flip-card', {id: this.card.id, index: this.index})
        }
      }
    },
  }
</script>

<style scoped>
</style>