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
      path: '/admin',
      name: 'admin',
      component: () => import('../views/AdminView.vue')
    },
    {
      path:'/jefatura',
      name: 'jefatura',
      component: () => import('../views/JefaturaView.vue')
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/analista',
      name: 'analista',
      component: () => import('../views/AnalistaView.vue')
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
    },
    {
      path: '/historial',
      name: 'historial',
      component: () => import('../views/HistorialView.vue')
    }
  ]
})

export default router
