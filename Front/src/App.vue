<template>
  <v-app id="inspire">
    <v-app-bar app>
      <v-toolbar-title>Jogo da Memória</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container fluid>
        <v-fade-transition mode="out-in">
          <router-view></router-view>
        </v-fade-transition>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data() {
    return {};
  },
  created() {
    //CHAMADA PRO BANCO
  },
};
</script>

<script>
import ViewAnimal from "./views/ViewAnimal.vue";
import ViewGame from "./views/ViewGame.vue";
import ViewLevelSelect from "./views/ViewLevelSelect.vue";
import ViewLogin from "./views/ViewLogin.vue";
import ViewMenu from "./views/ViewMenu.vue";
import ViewRanking from "./views/ViewRanking.vue";
import ViewRegister from "./views/ViewRegister.vue";
import ViewZoo from "./views/ViewZoo.vue";

export default {
  components: {
    ViewAnimal,
    ViewGame,
    ViewLevelSelect,
    ViewLogin,
    ViewMenu,
    ViewRanking,
    ViewRegister,
    ViewZoo,
  },

  data: () => ({
    //
  }),
};
</script>
