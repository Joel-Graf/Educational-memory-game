import Vue from "vue";
import Vuex from 'vuex';

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    logged: false,
    userId: -1,
    userLevel: 0,
  },
  mutations: {
    logIn (state, payload) {
      state.logged = true
      state.userId = payload.userId,
      state.userLevel = payload.userLevel
    },
    logOut (state) {
      state.logged = false,
      state.userId = -1,
      state.userLevel = 0
    }
  }
})

export default store
