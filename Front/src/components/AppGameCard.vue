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
        :src="require('@/assets/Imagens/' + LevelName + '/' + LevelName.toLowerCase() + '.jpg')" 
      ></v-img>
    </div>
  </v-card>
</template>

<script>
export default {
  props: {
    LevelName: {
      type: String,
      required: true,
    },
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
// Facil = 8 , Media = 14, Dificil = 20
</script>

<style scoped>
  .facil{
    max-width: 240px;
    max-height: 380px;
    margin:auto;
  }
  
  .Media{
    width: 13%;
    height: 44%;
  }
  .Media #teste{
    height: 40vh;
  }

  .Dificil{
    width: 10%;
    height: 30%;
  }

  .Dificil #teste{
   height: 26.6vh;
  }

</style>
