import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/home",
    name: "home",
    component: HomeView,
    redirect: '/home/apply',
    children: [
      {
        path: 'apply', name: 'apply', component: () =>
          import(/* webpackChunkName: "apply组件" */ "../views/Fruit/apply.vue"),
      },
      {
        path: 'banana', name: 'banana', component: () =>
          import(/* webpackChunkName: "banana组件" */ "../views/Fruit/banana.vue"),
      },
      {
        path: 'formdata', name: 'formdata', component: () =>
          import(/* webpackChunkName: "formdata组件" */ "../views/FormData/index.vue"),
      },
      {
        path: 'strawberry', name: 'strawberry', component: () =>
          import(/* webpackChunkName: "草莓组件" */ "../views/Fruit/strawberry.vue"),
      },
      {
        path: 'liu', name: 'liu', component: () =>
          import(/* webpackChunkName: "榴莲组件" */ "../views/Fruit/liu.vue"),
      },
    ]
  },
  {
    path: "/",
    name: "login",
    component: () =>
      import(/* webpackChunkName: "login" */ "../views/Login_In.vue"),
  },
  {
    path: "/register",
    name: "register",
    component: () =>
      import(/* webpackChunkName: "register" */ "../views/Login_Up.vue"),
  },
  {
    path: "/about",
    name: "about",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },

];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
