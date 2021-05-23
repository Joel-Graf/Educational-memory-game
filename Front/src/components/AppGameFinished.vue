<template>
  <div class="d-flex flex-column align-center my-5">
    <h1 class="my-5">
      {{ this.GameResult == "Vitória" ? "VOCÊ PASSOU !" : "FOI QUASE !" }}
    </h1>
    <v-btn
      @click="restartGame"
      class="my-5"
      color="primary"
      x-large
      min-width="20%"
    >
      <v-icon class="mr-4">mdi-restart</v-icon>
      {{ this.GameResult == "Vitória" ? "Jogar Novamente" : "Reiniciar" }}
    </v-btn>
    <v-btn
      @click="exitGame"
      class="my-5"
      color="secondary"
      large
      min-width="10%"
    >
      Sair
    </v-btn>
  </div>
</template>

<script>
export default {
  props: {
    GameResult: {
      type: String,
      required: true,
    },
  },
  data() {
    return {};
  },
  methods: {
    restartGame() {
      //TODO: Reiniciar o nível jogado
    },
    exitGame() {
      //TODO: Redirecionar para tela de Seleção de Level
    },
  },
};
</script>

<style></style>
