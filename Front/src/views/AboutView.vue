<template>
  <v-layout class="rounded rounded-md">
    <v-app-bar> 
      <v-avatar> <img alt="Vue logo" class="logo" src="@/assets/STULOGO.png" width="49" height="50" /> </v-avatar>
     
      <v-btn to="/"> Inicio </v-btn>
      <v-btn> Ticket </v-btn>
      <v-btn> Historial </v-btn>
    </v-app-bar>
<!--
    <v-navigation-drawer>
      <v-list>
        <v-list-item title=aaa></v-list-item>
      </v-list>
    </v-navigation-drawer>
-->
    <v-main class="d-flex align-center justify-center" style="min-height: 300px;">
      Main Content
    </v-main>
  </v-layout>
</template>

<!--
<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
</template>

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