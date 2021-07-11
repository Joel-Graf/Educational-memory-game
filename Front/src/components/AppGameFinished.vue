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
    <router-link :to="exit">
      <v-btn class="my-5" color="secondary" large min-width="10%">
        <v-icon left dark>mdi-arrow-left</v-icon>
        Sair
      </v-btn>
    </router-link>
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
    return {
      exit: "/Menu",
    };
  },
  methods: {
    restartGame() {
      this.$router.push("Zoo");
    },
  },
  mounted() {
    var opts = {
      id: this.$store.state.matchId,
      alunoId: this.$store.state.userId,
      tempoJogado: this.$store.state.tempoDecorrido,
      status: this.GameResult.toUpperCase(),
    };
    fetch("http://localhost:8090/pac3/finishGame", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(opts),
    })
      .then((response) => {
        if (response.status !== 201) {
          console.log("Request Error! Status: " + response.status);
          return;
        }
        if(this.GameResult.toUpperCase() == "VITÓRIA") {
          if(this.$store.state.userLevel < 4) {
            this.$store.state.userLevel += 1
          } else {
            this.$store.state.userLevel = 4
          }
        }
      })
      .catch((error) => {
        console.log("Fetch Error! " + error);
      });
  },
};
</script>

<style></style>
