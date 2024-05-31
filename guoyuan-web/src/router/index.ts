import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";
import { getCookie } from '@/unite/cookie'
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
      // {
      //   path: 'strawberry', name: 'strawberry', component: () =>
      //     import(/* webpackChunkName: "草莓组件" */ "../views/Fruit/strawberry.vue"),
      // },
      // {
      //   path: 'liu', name: 'liu', component: () =>
      //     import(/* webpackChunkName: "榴莲组件" */ "../views/Fruit/liu.vue"),
      // },
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

router.beforeEach((to, from, next) => {
  let token = getCookie('token');
  // 携带token了,已经登录过了
  if (token) {
    //已经登录了，如果还想登录或注册不允许
    if (to.path == '/' || to.path == '/register') {
      //已经登录了，不允许去登录和注册了
      next('/home/apply')
    } else {
      //如果登录了，但权限是用户的，不放行去管理员页面
      let auth = getCookie('user')
      console.log(auth, 'user');

      if (auth !== '管理员' && to.path === '/home/Manage') {
        next('/home/403')
        /*
          let adminPath = ['/user']
          let user = JSON.parse(localStorage.getItem('user')||'{}'){
            if(user.auth !== '管理员' && adminPath.includes(to.path)){

            }
          }
        */
      } else {
        //登录了,但去别的页面，放行
        next();
      }

    }
  }
  // console.log(token );
  //没有携带token的时候直接放行
  next()
})

export default router;
