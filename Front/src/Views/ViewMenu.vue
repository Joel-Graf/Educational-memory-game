<template>
    <v-container fluid id="container">
        <div id="main">
            <h1 id="tittle">
            Menu
            </h1>
            <v-btn id="play" outlined color="indigo" @click="togglePlay">Jogar</v-btn><br>
            <Drawer @close="togglePlay" align="left" :closeable="true">
                <div v-if="openPlay" class="content"><ViewGame/></div>
            </Drawer>

            <v-btn id="ranking" outlined color="indigo" @click="toggleRanking">Ranking</v-btn><br>
            <Drawer @close="toggleRanking" align="left" :closeable="true">
                <div v-if="openRanking" class="content"><ViewRanking/></div>
            </Drawer>
            
            <v-btn id="zoo" outlined color="indigo" @click="toggleZoo">Zoológico</v-btn><br>
            <Drawer @close="toggleZoo" align="left" :closeable="true">
                <div v-if="openZoo" class="content"><ViewZoo/></div>
            </Drawer>

            <v-btn id="quit" outlined color="indigo"  @click="quit">Sair</v-btn>
        </div>
    </v-container>
</template>

<script>

import ViewRanking from './ViewRanking.vue';
import ViewGame from './ViewGame.vue';
import ViewZoo from './ViewZoo.vue';

export default {
    data() {
        return {
            openPlay: false,
            openRanking: false,
            openZoo: false
        }
    },
    components: {
        ViewGame,
        ViewRanking,
        ViewZoo
    },
    methods: {
        togglePlay() {
            this.openPlay = !this.openPlay
        },
        toggleRanking() {
            this.openRanking = !this.openRanking
        },
        toggleZoo() {
            this.openZoo = !this.openZoo
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