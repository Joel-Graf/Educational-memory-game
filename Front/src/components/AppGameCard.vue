<template class="interface">
  <v-card
    elevation="5"
    @click="clickCard"
    :class="Dificulty"
  >
    <div v-if="isFliped" >
      <v-img
        id="teste"
        class="mx-auto my-auto d-flex justify-center align-center"
        
      >
        <div style="background-color:rgba(0,0,0,0.2)">
          <p class='text-h6 text-center' style="color:white">{{ card.name.toUpperCase() }}</p>
        </div>
      </v-img>
    </div>
    <div v-else>
      <v-img
        id="teste"
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
    Dificulty: {
      type: String,
      required:true,
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
// Facil = 6 , Media = 8, Dificil = 12
</script>

<style scoped>
  .FacilMedia{
    max-width: 240px;
    max-height: 380px;
    margin:auto;
  }

  .Dificil{
    width: 210px;
    height: 280px;
    margin: auto;
  }

  .Dificil #teste{
    width: 100%;
    height: 280px;
  }

</style>
