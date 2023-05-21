import Vue from 'vue'
import VueRouter from 'vue-router'
import BeforeLogin from '../views/BeforeLogin.vue'
import AfterLogin from '../views/AfterLogin.vue'
import UserPage from '../views/UserPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/start',
    name: 'start',
    component: BeforeLogin,
  },
  {
    path: '/user',
    name: 'user',
    component: UserPage,
    children: [
      {
        path: "login",
        name: "login-page",
        component: () => import("@/components/user/UserLogin.vue")
      },
      {
        path: "regist",
        name: "regist-page",
        component: () => import("@/components/user/UserRegist.vue")
      },
    ]
  }, 
  {
    path: '/',
    name: 'main-page',
    component: AfterLogin,
    children: [
      {
        path: "",
        name: "user-main",
        component: () => import("@/components/video/LoginMain.vue")
      },
      {
        path: "list",
        name: "video-list",
        component: () => import("@/components/video/LoginList.vue")
      },
      {
        path: "video",
        name: "video-detail",
        component: () => import("@/components/video/LoginVideo.vue")
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
