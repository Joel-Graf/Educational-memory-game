<template>
    <v-container fluid id="container">
        <div id="mainHeader">
            <h3>Aluno</h3>
            <h3>Fase</h3>
            <h3>Tempo médio</h3>
        </div>
    </v-container>
</template>

<script>
export default {
    data() {
    },
    components: {
    },
    methods: {
    }
}

</script>

<style scoped>

#mainHeader{
    display: grid;
    grid-template-columns: 33% 33% 33%;
    font-family: Arial, Helvetica, monospace;
    color: #7783CA;
    align-items: start;
    padding: 40px 0px 20px 0px;
}
</style>