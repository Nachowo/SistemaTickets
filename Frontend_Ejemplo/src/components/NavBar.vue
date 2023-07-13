<template>
    <v-app-bar>
      <v-toolbar>
        <v-avatar class="icon">
          <img
            alt="Vue logo"
            class="logo"
            src="@/assets/STULOGO.png"
            width="47"
            height="40"
          />
        </v-avatar>
  
        <v-btn variant="plain" to="/about">Inicio</v-btn>
        <v-btn variant="plain" to="/ticket">Ticket</v-btn>
        <v-btn variant="plain" to="/historial">Historial</v-btn>
        <v-spacer></v-spacer>
        <v-btn variant="plain" to="/">
          Cerrar Sesión
          <v-icon class="icon"
            ><img
              alt="Cerrar sesión"
              src="@/assets/cerrar-sesion.png"
              width="25"
              height="16"
          /></v-icon>
        </v-btn>
      </v-toolbar>
    </v-app-bar>
  </template>
  <script>
  export default {
    name: "NavBar",
  };
  </script>
  