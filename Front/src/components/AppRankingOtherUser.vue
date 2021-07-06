<template>
  <v-container fluid id="container">
    <div id="main">
      <ul >
        <li v-for="item in allAlunos" :key="item.id" class="list">
          <div class="aluno">{{ item.nome }} </div>
          <div class="fase">
            <v-slider
              class="slider"
              color="primary"
              height="70"
              min="1"
              max="15"
              :value="item.fase"
              readonly
              thumb-label="always"
            >
            </v-slider>
          </div>
          <div class="tempo"> {{ item.tempoMedio }}</div>
        </li>
      </ul>
    </div>
  </v-container>
</template>

<script>
/* 
  <template v-slot: item.phase="{ item }">
          <v-slider
            class="slider"
            color="primary"
            height="70"
            min="1"
            max="15"
            :value="item.nome"
            readonly
            thumb-label="always"
          >
            {{ phase }}
          </v-slider>
        </template>
*/
export default {
  props: {
    allAlunos: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      headers: [
        { value: "name", align: "center", width: "33%" },
        { value: "phase", align: "center", width: "33%" },
        { value: "averageTime", align: "center", width: "33%" },
      ]
    };
  },
};
</script>
<style scoped>
.slider {
  margin-top: 3em;
}

.list {
  background: #cecece;
  margin: 10px;
  display: flex;
  font-weight: 2; 
  padding: 0px; 
  align-items: center; 
  justify-content: center; 
  text-align: center; 
  width: 90%; 
  margin: 15px auto; 
  height: 78px; 
  background: #F0F0F0;
  box-shadow: 0px 0px 8px #cecece; 
  border-radius: 0px 10px 10px 0px; 
  border-left: 5px solid blue;
}

 .aluno{
   width: 33%; 
   font-size: 24px;
   font-weight: 300;
 }

 .fase{
   margin-top: 25px;
   width: 33%;
 }

 .tempo{
   width: 33%;
   font-size: 25px;
   font-weight: 300;
 }
</style>