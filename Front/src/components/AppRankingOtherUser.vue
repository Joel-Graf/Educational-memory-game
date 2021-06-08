<template>
  <v-container fluid id="container">
    <div id="main">
      <v-data-table
        :headers="headers"
        :items="dataUsers"
        :items-per-page="5"
        :value="phase"
      >
        <template v-slot:item.phase="{ item }">
          <v-slider
            class="slider"
            color="primary"
            height="70"
            min="1"
            max="15"
            :value="item.currentPhase"
            readonly
            thumb-label="always"
          >
          {{phase}}
          </v-slider>
        </template>
      </v-data-table>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      headers: [
        { value: "name", align: "center", width: "33%" },
        { value: "phase", align: "center", width: "33%" },
        { value: "averageTime", align: "center", width: "33%" },
      ],
      dataUsers: [
        {
          id: 1,
          name: "Ciclano Jerun",
          currentPhase: 6,
          averageTime: 53.9,
        },
        {
          id: 2,
          name: "Fulano de tal",
          currentPhase: 8,
          averageTime: 29.1,
        },
        {
          id: 3,
          name: "Beltrano Xevudor",
          currentPhase: 8,
          averageTime: 10.0,
        },
        {
          id: 4,
          name: "Riuro ano",
          currentPhase: 2,
          averageTime: 10.1,
        },
        {
          id: 5,
          name: "Podoki Erbeuloa",
          currentPhase: 5,
          averageTime: 13.3,
        },
        {
          id: 6,
          name: "Papaelu Hasorid",
          currentPhase: 4,
          averageTime: 34.0,
        },
        {
          id: 7,
          name: "Zucal Arceaim",
          currentPhase: 9,
          averageTime: 74.4,
        },
        {
          id: 8,
          name: "Kihal Bumnemgog",
          currentPhase: 6,
          averageTime: 12.0,
        },
        {
          id: 9,
          name: "Weudo Heocitwog",
          currentPhase: 4,
          averageTime: 23.2,
        },
        {
          id: 10,
          name: "Tiaca Erbeuloa",
          currentPhase: 3,
          averageTime: 14.2,
        },
      ]
    };
  },
};
</script>
<style scoped>

.slider{
  margin-top: 3em;
}

</style>