<template id="interface">
  <div>
    <router-link
      to="/Game"
      style="cursor:auto; text-decoration:none"
    >
    {{teste}}
      <v-card
        elevation="5"
        class="mx-auto my-6"
        width="324"
        height="332"
        @click="criaJogo"
        :disabled="Level.isLevelLocked"
      >
        <v-img  height="100%" width="100%" class="mx-0 mb-2">
          <v-card-title
            class="
              d-flex
              justify-space-between
              text-uppercase
              font-weight-medium
            "
          >

            <span>{{ Dificuldade.nome }}</span>
            <span>{{ Level.nome }}</span>
          </v-card-title>

          <div
            v-if="Level.isLevelLocked"
            class="d-flex justify-center align-center"
            style="height: 100%"
          >
            <v-icon x-large style="transform: scale(3)">mdi-lock-alert</v-icon>
          </div>
        </v-img>
      </v-card>
    </router-link>
  </div>
</template>

<script>
export default {
  props: {
    Level: {
      type: Object,
      required: true,
    },
    Dificuldade: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      teste:"../assets/Imagens/oceano/oceano.jpg",
      oi:"oceano"
    };
  },
  methods: {
    criaJogo() {
      this.$store.commit('criaJogo', { level: this.Level, dificuldade: this.Dificuldade})
    }
  },
};
</script>

<style>
  #teste{
    background-image:url('../assets/Imagens/oceano/oceano.jpg');
    background-size: 100% 100%;
  }
</style>
