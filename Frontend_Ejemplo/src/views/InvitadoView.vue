<script>
  export default {
    data: () => ({
      rules3: {
        required: value => !!value || 'Correo requerido',
      },
    }),
  }
</script>

<template> 
    <header>
        <img alt="Vue logo" class="logo" src="@/assets/STULOGO2.png" width="450" height="200" />
  </header>
  
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="8"
      max-width="500"
      rounded="lg"
    >
      <div class="text-subtitle-1 text-medium-emphasis">Cuenta</div>
      <v-responsive
    class="mx-auto"
    max-width="400"
  >
    <v-text-field
    :rules="[rules3.required]"
      clearable
      hide-details="auto"
      label="Direccion de correo electronico"
      placeholder="carlos.vera@usach.cl"
      type="email"
    ></v-text-field>
  </v-responsive>
        <v-card-text class="text-medium-emphasis text-caption">
          Estimado usuario se le solicita escribir algun correo el cual podamos comunicarnos para efecto de seguimiento de su ticket.
        </v-card-text>
      <v-btn
        block
        class="mb-8"
        color="surface-variant"
        size="large"
        variant=""
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
        </a>
      </v-card-text>
    </v-card>
  </div>
</template>