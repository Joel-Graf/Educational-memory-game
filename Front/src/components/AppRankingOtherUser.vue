<template>
    <v-container fluid id="container">
        <v-responsive class="overflow-y-auto" max-height="400">
            <div id="main">
                <h2>{{name}}</h2>
                <v-slider id="slider"
                    v-model="currentPhase"
                    :label="Fase"
                    color="#7783CA"
                    thumb-label="always"
                    max="20"
                ></v-slider>
                <h2>{{averageTime}}</h2>
            </div>
        </v-responsive>
    </v-container>
</template>

<script>
export default {
    props: {
        id: {
            type: Number
        },
        name: {
            type: String
        },
        currentPhase: {
            type: Number
        },
        averageTime: {
            type: Number
        }
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
    padding: 40px 0px 40px 0px;
    font-size: small;
}

</style>