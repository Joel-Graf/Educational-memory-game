<template id="interface">
  <div>
    <v-card
      elevation="5"
      class="mx-auto my-6"
      width="324"
      height="332"
      v-on="!Level.isLevelLocked ? { click: () => criaJogo() } : {}"
      :disabled="Level.isLevelLocked"
    >
      <v-img
        height="100%"
        width="100%"
        class=" mb-2"
        :src="
          require('@/assets/Imagens/' +
            Level.nome +
            '/' +
            Level.nome.toLowerCase() +
            '_fundo.jpg')
        "
      >
        <v-card-title
          class="
            d-flex
            justify-space-between
            text-uppercase
            font-weight-medium
          "
        >
          <span>{{ Dificuldade.nome }}</span>
          <span>{{ Level.nome }}</span>
        </v-card-title>

        <div
          v-if="Level.isLevelLocked"
          class="d-flex justify-center align-center"
          style="height: 100%"
        >
          <v-icon x-large style="transform: scale(3)">mdi-lock-alert</v-icon>
        </div>
      </v-img>
    </v-card>
  </div>
</template>

<script>
export default {
  props: {
    Level: {
      type: Object,
      required: true,
    },
    Dificuldade: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {};
  },
  methods: {
    criaJogo() {
      this.$store.commit("criaJogo", {
        level: this.Level,
        dificuldade: this.Dificuldade,
      });
      this.$router.push("Game");
    },
  },
};
</script>

<style>

</style>
