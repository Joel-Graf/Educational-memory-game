<template>
    <v-container fluid id="container">
        <div id="mainUser">
            <h2>{{dataUser.name}}</h2>
            <v-slider id="slider"
                v-model="dataUser.currentPhase"
                :label="Fase"
                color="#000000"
                thumb-label="always"
                max="20"
            ></v-slider>
            <h2>{{dataUser.averageTime}}</h2>
        </div>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            labelPhase: "Fase",
            labelTime: "Tempo médio",
            dataUser: {
                name: "Nathan Stüber Antunes",
                currentPhase: 5,
                averageTime: 40.3,
            }
            
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

#mainUser{
    display: grid;
    grid-template-columns: 33% 33% 33%;
    border-bottom: solid 2px #7783CA;
    font-family: Arial, Helvetica, monospace;
    align-items: start;
    padding: 40px 0px 40px 0px;
}

</style>