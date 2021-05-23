<template>
  <v-app id="inspire">
    <v-app-bar app>
      <v-toolbar-title>Jogo da Memória</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container fluid>
        <v-fade-transition mode="out-in">
          <ViewMenu/>
        </v-fade-transition>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

import ViewMenu from './Views/ViewMenu.vue';

export default {
  components: {
    ViewMenu,
  },
  data: () => ({
    //
  }),
};
</script>