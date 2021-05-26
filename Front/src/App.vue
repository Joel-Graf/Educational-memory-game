<template>
  <v-app id="inspire">

    <v-main>
      <v-container fluid>
        <v-fade-transition mode="out-in">
          <!-- <router-view></router-view> -->
          <ViewLogin/>
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
import ViewGame from './Views/ViewGame.vue';
import ViewLogin from './Views/ViewLogin.vue';

export default {
  components: {
    ViewGame,
    ViewLogin
  },

  data: () => ({
    //
  }),

};
</script>
