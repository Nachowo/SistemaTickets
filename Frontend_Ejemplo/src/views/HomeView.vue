<script>

  export default {
    data: () => ({
      rules: {
        required: value => !!value || 'Contraseña requerida',
      },
      rules2: {
        required: value => !!value || 'Correo requerido',
      },
      visible: false,
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
      max-width="448"
      rounded="lg"
    >
      <div class="text-subtitle-1 text-medium-emphasis">Cuenta</div>

      <v-responsive
    class="mx-auto"
    max-width="344"
  >
    <v-text-field
      :rules="[rules2.required]"
      clearable
      placeholder="Introduzca su correo"
      variant="outlined"

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
      :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
      :type="visible ? 'text' : 'password'"
      :rules="[rules.required]"
      clearable
      placeholder="Introduzca su contraseña"
      variant="outlined"
      @click:append-inner="visible = !visible"

    ></v-text-field>
    </v-responsive>
      <RouterLink to="/about">
        <v-btn
          block
          class="mb-1"
          color="surface-variant"
          size="large"
          variant=""
        ><div class="log-in">INICIAR SESIÓN</div>
        </v-btn>
      </RouterLink>

      <v-card-text class="text-center">
        <a
          class="text-blue text-decoration-none"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
        <RouterLink to="/invitado">
          <v-btn
          block
          class="mb-1"
          size="large"
          color="surface-variant"
          variant=""
          ><div class="log-in">INVITADO</div>
          </v-btn>
        </RouterLink>
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

<style>
body {
  background-color:  #424953;
}
.log-in { color:  #11be8d;

}
</style>




