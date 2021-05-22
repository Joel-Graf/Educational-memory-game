<template>
  <v-card
    elevation="5"
    class="mx-auto my-6"
    width="324"
    height="332"
    @click="clickCard"
  >
    <div v-if="isFliped">
      <v-card-title
        class="d-flex justify-space-between text-uppercase font-weight-medium"
      >
        <span>({{ card.id }})</span>
        <span>{{ card.name }}</span>
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
  </v-card>
</template>

<script>
export default {
  props: {
    Card: {
      type: Object,
      required: true,
    },
    Index: {
      type: Number,
      required: true,
    },
    CardsFliped: {
      type: Array,
      required: true,
    },
    IsGameLocked: {
      type: Boolean,
      required: true,
    },
  },
  data() {
    return {
      card: this.Card,
      isFliped: false,
    };
  },
  methods: {
    playSound() {
      //TODO: Implementar bloqueio para SPAM
      var audio = new Audio(require(`@/assets/${this.card.sound}`));
      audio.play();
    },
    clickCard() {
      if (this.isFliped || this.IsGameLocked) {
        //TODO: Carta já virada ou jogo trancado, rodar animação de erro
      } else {
        this.isFliped = true;
        this.$emit("flip-card", {
          id: this.card.id,
          animalId: this.card.animalId,
          index: this.Index,
        });
      }
    },
  },
};
</script>

<style scoped></style>
