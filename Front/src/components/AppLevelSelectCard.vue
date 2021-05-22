<template>
  <v-card
    elevation="5"
    class="mx-auto my-6"
    width="324"
    height="332"
    @click="clickCard"
    :disabled="level.isLevelLocked"
  >
    <v-img height="260" class="mx-3 mb-2">
      <v-card-title
        class="d-flex justify-space-between text-uppercase font-weight-medium"
      >
        <span>{{ dificuldade }}</span>
        <span>{{ level.nome }}</span>
      </v-card-title>
      <div
        v-if="level.isLevelLocked"
        class="d-flex justify-center align-center"
        style="height:100%;"
      >
        <v-icon x-large style="transform:scale(3);">mdi-lock-alert</v-icon>
      </div>
    </v-img>
  </v-card>
</template>

<script>
export default {
  props: {
    level: {
      type: Object,
      required: true,
    },
    dificuldade: {
      type: String,
      required: true,
    },
  },
  data() {
    return {};
  },
  methods: {
    clickCard() {
      //TODO: Redirecionar para a fase do jogo
    },
  },
};
</script>

<style></style>
