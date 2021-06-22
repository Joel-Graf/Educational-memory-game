<template>
  <v-container fluid id="container">
    <router-link to="/Menu">
        <v-btn style="position:absolute" left color="secondary" medium min-width="10%">
            <v-icon left dark>mdi-arrow-left</v-icon>Voltar
        </v-btn>
    </router-link>

    <div class="d-flex flex-column align-center">
      <h1>Ranking</h1>
      <AppRankingHeader />
      <AppRankingUser />
      <AppRankingOtherUser />
    </div>
  </v-container>
</template>



<script>
import AppRankingOtherUser from "../components/AppRankingOtherUser";
import AppRankingUser from "../components/AppRankingUser.vue";
import AppRankingHeader from "../components/AppRankingHeader.vue";

export default {
  data() {
    return {
    };
  },
  components: {
    AppRankingHeader,
    AppRankingUser,
    AppRankingOtherUser,
  },
};
</script>

<style> 

</style>