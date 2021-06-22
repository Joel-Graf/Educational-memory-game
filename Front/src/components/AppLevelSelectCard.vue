<template id="interface">
  <div>
    <router-link :to="`${this.route}`" props="teste" style="cursor:auto; text-decoration:none">
      <v-card
        elevation="5"
        class="mx-auto my-6"
        width="324"
        height="332"
        @click="selectLevel"
        :disabled="Level.isLevelLocked"
      >
        <v-img height="260" class="mx-3 mb-2">
          <v-card-title
            class="
              d-flex
              justify-space-between
              text-uppercase
              font-weight-medium
            "
          >
            <span>{{ Dificuldade }}</span>
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
    </router-link>

    {{ this.mostrarJogo ? this.jogo : undefined }}
  </div>
</template>

<script>
//import ViewGame from "../Views/ViewGame.vue";

export default {
  props: {
    Level: {
      type: Object,
      required: true,
    },
    Dificuldade: {
      type: String,
      required: true,
    },
  },
  components: {
    //ViewGame
  },
  data() {
    return {
      mostrarJogo: false,
      jogo: <ViewGame />,
      route: '/LevelSelect'
    };
  },
  methods: {
    selectLevel: function () {
      this.route = '/Game'
    },
  },
};
</script>

<style></style>
