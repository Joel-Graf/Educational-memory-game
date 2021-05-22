<template>
  <v-app id="inspire">
    <v-app-bar app>
      <v-toolbar-title>Jogo da Memória</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container fluid>
        <v-fade-transition mode="out-in">
          <!-- <router-view></router-view> -->
          <ViewGame/>
        </v-fade-transition>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    data() {
      return {
        cards: [
          {nome: 'Monalisa', Autor: 'DiCaprio', id: 1},
          {nome: 'Monalisa2', Autor: 'DiCaprio2', id: 2}
        ]
      }
    },
    created() {
      //CHAMADA PRO BANCO
    }
  }
</script>

<script>
import ViewGame from './views/ViewGame.vue';

export default {
  components: {
    ViewGame,
  },

  data: () => ({
    //
  }),

};
</script>
