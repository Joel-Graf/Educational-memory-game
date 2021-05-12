<template>
  <div>
    <AppGameHeader/>
    <AppGameCard/>
  </div>
</template>

<script>
import AppGameHeader from '../components/AppGameHeader.vue';
import AppGameCard from '../components/AppGameCard.vue';

export default {
  components: {
    AppGameCard,
    AppGameHeader,
  },

  data: () => ({
    //
  }),

};
</script>

<style>

</style>