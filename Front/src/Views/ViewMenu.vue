<template>
    <v-container fluid id="container">
        <div id="main">
            <h1 id="tittle">
            Menu
            </h1>
            <v-btn id="play" outlined color="indigo" :href="play">Jogar</v-btn><br>
            <v-btn id="ranking" outlined color="indigo" :href="ranking">Ranking</v-btn><br>
            <v-btn id="zoo" outlined color="indigo" :href="zoo">Zoológico</v-btn><br>
            <v-btn id="quit" outlined color="indigo">Sair</v-btn>
        </div>
    </v-container>
</template>

<script>

import ViewGame from 'ViewGame.vue';
export default {
    data: () => ({
    }),
    components: {
        ViewGame
    },
    methods: {
        play: function play() {
            document.getElementById("#main").innerHTML = <ViewGame/>
        }
    },
}

</script>

<style scoped>

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