import Vue from "vue";
import Vuex from 'vuex';

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    logged: false,
    userLevel: 0
  },
  // mutations: {
  //   logIn (state) {
  //     state.logged = true
  //   },
  //   logOut (state) {
  //     state.logged = false
  //   }
  // }
})

export default store
