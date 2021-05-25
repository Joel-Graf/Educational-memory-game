<template>
    <v-container fluid id="container">
        <v-responsive class="overflow-y-auto" max-height="400">
            <div id="main">
                <h2>{{dataUser.name}}</h2>
                <v-slider id="slider"
                    v-model="dataUser.currentPhase"
                    :label="Fase"
                    color="#7783CA"
                    thumb-label="always"
                ></v-slider>
                <h2>{{dataUser.averageTime}}</h2>
            </div>
        </v-responsive>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            dataUsers: [
                {
                    id: 1,
                    name: "Nathan Stüber Antunes",
                    currentPhase: 5,
                    averageTime: 40.3
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
                
            ]
        }
    },
    components: {
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
    display: grid;
    grid-template-columns: 33% 33% 33%;
    font-family: Arial, Helvetica, monospace;
    color: #8D8D8D;
    align-items: start;
}

</style>