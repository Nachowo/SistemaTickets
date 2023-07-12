import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/invitado',
      name: 'invitado',
      component: () => import('../views/InvitadoView.vue')
    },
    {
      path: '/ticket',
      name: 'ticket',
      component: () => import('../views/TicketView.vue')
    }
  ]
})

export default router
