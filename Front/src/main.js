import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router/index";

Vue.config.productionTip = false;

Vue.use(Router)

new Vue({
  router,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
