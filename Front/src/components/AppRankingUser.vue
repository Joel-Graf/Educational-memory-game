<template>
  <v-container fluid id="container">
    <div id="mainUser">
      <h2 class="text-center">{{ dataUser.name }}</h2>
      <v-slider
        id="slider"
        v-model="dataUser.currentPhase"
        color="#000000"
        thumb-label="always"
        min="1"
        max="15"
      ></v-slider>
      <h2 class="text-center">{{ dataUser.averageTime }}</h2>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      dataUser: {
        name: "Nathan Stüber Antunes",
        currentPhase: 5,
        averageTime: 40.3,
      },
    };
  },
};
</script>

<style scoped>
#mainUser {
  display: grid;
  grid-template-columns: 33% 34% 33%;
  align-items: start;
  padding: 40px 0px 0px 0px;
}
</style>
