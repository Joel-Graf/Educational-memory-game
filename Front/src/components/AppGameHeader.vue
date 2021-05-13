<template>
  <div>
    <!-- Titulo -->
    <div>{{dificulty.name}}</div>
    
    <!-- Contagem de carta -->
    <div>{{cardPairsRemaining}}/{{dificulty.cardQuantity/2}}</div>

    <!-- Tempo restante -->
    <div>{{timeRemaining}}</div>
  </div>
</template>

<script>
export default {
  props: {
    pDificulty: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      dificulty: this.pDificulty,
      cardPairsRemaining: this.pDificulty.cardQuantity/2,
      timeRemaining: this.pDificulty.timeLimit,
    }
  }
};
</script>

<style scoped>

</style>