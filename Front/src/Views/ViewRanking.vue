<template>
    <v-container fluid id="container">
        <div id="main">
            <h1 id="tittle">
            Ranking
            </h1>
            <AppRankingHeader/>
            <AppRankingUser/>
            <div v-for="dataUser in dataUsers" :key="dataUser.id">
                <AppRankingOtherUser :id="dataUser.id"  :name="dataUser.name"  :currentPhase="dataUser.currentPhase"  :averageTime="dataUser.averageTime"/>
            </div>
            <router-link to="/Menu">
                <v-btn id="back" outlined color="indigo">Voltar</v-btn>
            </router-link>
        </div>
    </v-container>
</template>

<script>

import AppRankingOtherUser from '../components/AppRankingOtherUser';
import AppRankingUser from '../components/AppRankingUser.vue';
import AppRankingHeader from '../components/AppRankingHeader.vue';

export default {
    data() {
        return {
            page: 1,
            dataUsers: [
                {
                    id: 1,
                    name: "Ciclano Jerun",
                    currentPhase: 6,
                    averageTime: 53.9
                },
                {
                    id: 2,
                    name: "Fulano de tal",
                    currentPhase: 8,
                    averageTime: 29.1
                },
                {
                    id: 3,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
                {
                    id: 4,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
                {
                    id: 5,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
                {
                    id: 6,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
                {
                    id: 7,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
                {
                    id: 8,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
                {
                    id: 9,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
                {
                    id: 10,
                    name: "Beltrano ano",
                    currentPhase: 1,
                    averageTime: 10.0
                },
            ]
        }
    },
    components: {
        AppRankingHeader,
        AppRankingUser,
        AppRankingOtherUser,
    },
    methods: {
    }
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

.v-btn{
    width: 150px;
    margin: 10px;
}

#back{
    margin: 4em;
}

</style>
