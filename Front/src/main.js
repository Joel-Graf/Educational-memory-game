import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router/index";
import Vuex from 'vuex';

Vue.use(Vuex)
Vue.config.productionTip = false;

const store = new Vuex.Store({
  state: {
    logged: false
  },
  mutations: {
    logIn (state) {
      state.logged = true
    },
    logOut (state) {
      state.logged = false
    }
  }
})

new Vue({
  router,
  vuetify,
  store,
  render: (h) => h(App),
}).$mount("#app");
