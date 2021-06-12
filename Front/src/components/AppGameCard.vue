<template>
  <v-card
    elevation="5"
    class="mx-auto my-6"
    :width="width"
    :height="height"
    @click="clickCard"
  >
    <div v-if="isFliped">
      <v-img
        :height="height-2"
        :width="width-2"
        class="mx-auto my-auto d-flex justify-center align-center"
        :src="require(`@/assets/${card.image}`)"
      >
        <div style="background-color:rgba(0,0,0,0.2)">
          <p class='text-h6 text-center' style="color:white">{{ card.name.toUpperCase() }}</p>
        </div>
      </v-img>
    </div>
    <div v-else>
      <v-img
        :height="height-2"
        :width="width-2"
        class="mx-auto my-auto"
        :src="require('@/assets/Imagens/Oceano/oceano.jpg')"
      ></v-img>
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
    height: {
      type: Number,
      required: true,
    },
    width: {
      type: Number,
      required: true,
    }
  },
  data() {
    return {
      card: this.Card,
      isFliped: false,
    };
  },
  methods: {
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
