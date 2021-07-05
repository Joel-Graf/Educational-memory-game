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
          <v-icon dark left> mdi-arrow-left </v-icon>Back
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
        { nome: "facil", qtd_cartas: 8, tempo_limite: 120 },
        { nome: "medio", qtd_cartas: 14, tempo_limite: 240 },
        { nome: "dificil", qtd_cartas: 20, tempo_limite: 300 },
      ],
      dificuldadeSelecionada: "facil",
      levels: [
        { id: 0, nome: "Floresta", imagem: "", isLevelLocked: false },
        { id: 1, nome: "Deserto", imagem: "", isLevelLocked: true },
        { id: 2, nome: "Mar", imagem: "", isLevelLocked: true },
        { id: 3, nome: "Minecraft", imagem: "", isLevelLocked: true },
      ],
      // TODO: Só desbloquear leveis com numero <= level do jog
    };
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
