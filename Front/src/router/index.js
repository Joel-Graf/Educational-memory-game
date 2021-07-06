import Vue from "vue";
import VueRouter from "vue-router";
import ViewAnimal from "../Views/ViewAnimal.vue";
import ViewGame from "../Views/ViewGame.vue";
import ViewLevelSelect from "../Views/ViewLevelSelect.vue";
import ViewLogin from "../Views/ViewLogin.vue";
import ViewMenu from "../Views/ViewMenu.vue";
import ViewRanking from "../Views/ViewRanking.vue";
import ViewRegister from "../Views/ViewRegister.vue";
import ViewZoo from "../Views/ViewZoo.vue";
import store from "../store/store.js"

Vue.use(VueRouter);

const routes = [
  {
    path: "/Game",
    name: "Game",
    component: ViewGame,
  },
  {
    path: "/Animal",
    name: "Animal",
    component: ViewAnimal,
  },
  {
    path: "/LevelSelect",
    name: "LevelSelect",
    component: ViewLevelSelect,
  },
  {
    path: "/Login",
    name: "Login",
    component: ViewLogin,
  },
  {
    path: "/Menu",
    name: "Menu",
    component: ViewMenu,
  },
  {
    path: "/Ranking",
    name: "Ranking",
    component: ViewRanking,
  },
  {
    path: "/Register",
    name: "Register",
    component: ViewRegister,
  },
  {
    path: "/Zoo",
    name: "Zoo",
    component: ViewZoo,
  },
  {
    path: "*",
    redirect: '/Login'
  },
];

const router = new VueRouter({
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.name !== 'Login' && to.name !== 'Register' && !store.state.logged) next({ name: 'Login' })
  else next()
})

export default router;
