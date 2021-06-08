<template>
    <v-container fluid id="container">
        <div id="main">
            <h1 id="tittle">
            Menu
            </h1>
            
            <router-link to="/Game">
                <v-btn id="play" outlined color="indigo"><v-icon left dark>mdi-play</v-icon>Jogar</v-btn><br>
            </router-link>
            
            <router-link to="/Ranking">
                <v-btn id="ranking" outlined color="indigo"><v-icon left dark>mdi-chart-areaspline</v-icon>Ranking</v-btn><br>
            </router-link>
            
            <router-link to="/Zoo">
                <v-btn id="zoo" outlined color="indigo"><v-icon left dark>mdi-paw</v-icon>Zoológico</v-btn><br>
            </router-link>

            <router-link to="/Login">
                <v-btn id="quit" outlined color="indigo"><v-icon left dark>mdi-logout</v-icon>Sair</v-btn>
            </router-link>
        </div>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
        }
    }
}

</script>

<style scoped>

.content{
    height: 40em;
}

#container{
    display: table;
    width: 100%;
}

#main{
   display: table-cell;
   text-align: center;
   vertical-align: middle;
   padding-top: 5em;
}

#tittle{
    margin-bottom: 30px;
}

.v-btn{
    width: 150px;
    margin: 10px;
}

</style>
