<template>
  <v-layout class="rounded rounded-md">
    <v-app-bar> 
      <v-toolbar>
      <v-avatar> <img alt="Vue logo" class="logo" src="@/assets/STULOGO.png" width="49" height="50" /> </v-avatar>
     
      <v-btn variant="plain" to="/about"> Inicio </v-btn>
      <v-btn variant="plain"> Ticket </v-btn>
      <v-btn variant="plain"> Historial </v-btn>
       
      </v-toolbar>
    </v-app-bar>

    <v-navigation-drawer>
      <v-list>
        <v-list-item></v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      Main Content
    </v-main>
  </v-layout>
</template>
<!--
<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
-->