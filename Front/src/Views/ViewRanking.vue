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
      alunoLogado: {},
      todosAlunos: []
    };
  },
  mounted() {
    fetch('http://localhost:8090/pac3/ranking', {
      "method": 'POST',
      "headers": {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    })
    .then((response) => {
      if(response.status !== 200) {
        console.log("Request Error! Status: "+response.status)
        return
      } 
      response.json().then((res) => { 
        var arr = res
        arr.forEach((item, index) => {
          if(item.id == this.$store.state.userId) {
            this.alunoLogado = item;
            arr.splice(index, 1);
          }
        })
        this.todosAlunos = arr
      })
    })
    .catch((error) => {
      console.log("Fetch Error! "+error)
    })
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