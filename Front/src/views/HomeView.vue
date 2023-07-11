<!--
<script setup>
import TheWelcome from '../components/TheWelcome.vue'
</script>
-->
<template> 
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/STULOGO.png" width="200" height="200" />
</header>

<div>
  <v-card
    class="mx-auto pa-12 pb-8"
    elevation="8"
    max-width="448"
    rounded="lg"
  >
    <div class="text-subtitle-1 text-medium-emphasis">Cuenta</div>

    <v-responsive
  class="mx-auto"
  max-width="344"
>
  <v-text-field
    hide-details="auto"
    label="Direccion de correo electronico"
    placeholder="carlos.vera@usach.cl"
    type="email"
  ></v-text-field>
</v-responsive>

    <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
      Contraseña

      <a
        class="text-caption text-decoration-none text-blue"
        href="#"
        rel="noopener noreferrer"
        target="_blank"
      >
      ¿Olvidó su contraseña?</a>
    </div>


  <v-responsive
  class="mx-auto"
  max-width="344"
  >
  <v-text-field
    label="Contraseña"
    type="input"
    hint="Introdusca su contraseña para entrar al sitio web"
  ></v-text-field>
  </v-responsive>
   
    <v-btn
      block
      class="mb-8"
      color="surface-variant"
      size="large"
      variant="tonal"
    >
    <RouterLink to="/about">INICIA SESION</RouterLink>
    </v-btn>

    <v-card-text class="text-center">
      <a
        class="text-blue text-decoration-none"
        href="#"
        rel="noopener noreferrer"
        target="_blank"
      >
      <v-btn
      block
      class="mb-8"
      size="large"
      color="surface-variant"
      variant="tonal"
      >INVITADO
      </v-btn>
      </a>
    </v-card-text>
  </v-card>
</div>
<!--
<main>
  <TheWelcome />
</main>
-->
</template>
