<template>
  <div>
    <v-banner>
      <router-link to="/Menu">
        <v-btn
          style="position:absolute"
          class="ma-2"
          color="dark darken-2"
          dark
        >
          <v-icon dark left> mdi-arrow-left </v-icon>Voltar
        </v-btn>
      </router-link>

      <div class="d-flex justify-center align-center">
        <span class="text-h5 mr-5 font-weight-medium"
          >Seleciona a fase e dificuldade:
        </span>

        <v-btn-toggle
          class="d-flex justify-center"
          rounded
          mandatory
          v-model="dificuldadeSelecionada"
        >
          <v-btn value="facil" active-class="success white--text">
            Fácil
          </v-btn>
          <v-btn value="medio" active-class="amber white--text"> Médio </v-btn>
          <v-btn value="dificil" active-class="red white--text">
            Difícil
          </v-btn>
        </v-btn-toggle>
      </div>
    </v-banner>
    <v-container fluid>
      <v-row align="center" justify="space-around">
        <AppLevelSelectCard
          v-for="level in levels"
          :key="level.id"
          :Level="level"
          :Dificuldade="dificuldade"
        />
      </v-row>
    </v-container>
  </div> 
</template>

<script>
import AppLevelSelectCard from "../components/AppLevelSelectCard.vue";

export default {
  components: {
    AppLevelSelectCard,
  },

  data() {
    return {
      dificuldades: [
        { id: 1, nome: "facil", qtd_cartas: 6, tempo_limite: 60 },
        { id: 2, nome: "medio", qtd_cartas: 10, tempo_limite: 90 },
        { id: 3, nome: "dificil", qtd_cartas: 14, tempo_limite: 120 },
      ],
      dificuldadeSelecionada: "facil",
      levels: [],
    };
  },
  mounted() {
    fetch("http://localhost:8090/pac3/bioma", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        if (response.status !== 200) {
          console.log("Request Error! Status: " + response.status);
          return;
        }
        response.json().then((res) => {
          res.forEach((item) => {
            item.isLevelLocked = item.id > this.$store.state.userLevel;
          });
          this.levels = res;
        });
      })
      .catch((error) => {
        console.log("Fetch Error! " + error);
      });
  },
  computed: {
    dificuldade() {
      var result;
      this.dificuldades.forEach((item) => {
        if (this.dificuldadeSelecionada == item.nome) result = item;
      });
      return result;
    },
  },
};
</script>

<style></style>
