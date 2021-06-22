<template>
  <div>
    <v-banner>
      <router-link to="/Menu">
        <v-btn style="position:absolute" class="ma-2" color="dark darken-2" dark>
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
          v-model="dificuldade"
        >
          <v-btn value="Fácil" active-class="success white--text">
            Fácil
          </v-btn>
          <v-btn value="Médio" active-class="amber white--text"> Médio </v-btn>
          <v-btn value="Difícil" active-class="red white--text">
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
      dificuldade: "facil",
      levels: [
        { id: 0, nome: "Floresta", imagem: "", isLevelLocked: false },
        { id: 1, nome: "Deserto", imagem: "", isLevelLocked: true },
        { id: 2, nome: "Mar", imagem: "", isLevelLocked: true },
        { id: 3, nome: "Minecraft", imagem: "", isLevelLocked: true },
      ],
    };
  },
};
</script>

<style></style>
