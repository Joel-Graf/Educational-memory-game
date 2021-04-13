<template>
  <v-app id="inspire">
    <v-app-bar app>
      <v-toolbar-title>Jogo da Memória</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <AppCard/>
      <AppCard/>
      <AppCard/>
      <AppCard/>
      <AppCard/>
      <AppCard/>
      <AppCard/>
      <AppCard/>
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
import AppCard from './components/AppCard';

export default {
  components: {
    AppCard,
  },

  data: () => ({
    //
  }),

};
</script>
