<template>
    <v-container fluid id="container">
        <div id="mainHeader" class="text-center">
            <h3>Aluno</h3>
            <h3>Fase</h3>
            <h3>Tempo médio</h3>
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

#mainHeader{
    display: grid;
    grid-template-columns: 33% 33% 33%;
    border-bottom: solid 2px #1976D2;
    color: #1976D2;
    padding: 40px 0px 20px 0px;
}

</style>