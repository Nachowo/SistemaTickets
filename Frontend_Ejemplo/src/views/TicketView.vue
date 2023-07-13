<script>
import NavBar from "../components/NavBar.vue";
export default {
  components: {
    NavBar,
  },

  data: () => ({
    email: "",
    emailRules: [
      (value) => {
        if (value) return true;

        return "Se requiere correo electrónico.";
      },
      (value) => {
        if (/.+@.+\..+/.test(value)) return true;

        return "El correo debe ser válido.";
      },
    ],
    select: null,
    items: ["Mantención", "Soporte"],
    checkbox: false,
  }),

  methods: {
    async validate() {
      const { valid } = await this.$refs.form.validate();

      if (valid) alert("Formulario enviado");
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },
  },
};
</script>

<template>
  <v-layout class="rounded rounded-md">
    <NavBar />
    <v-main class="custom-heigh centered-content">
      <v-sheet width="300" class="mx-auto">
        <v-form ref="form">
          <v-responsive class="mb-6" max-width="550">
            <v-text-field label="ID" hide-details="auto"></v-text-field>
          </v-responsive>

          <v-text-field
            v-model="name"
            :rules="emailRules"
            label="Direccion de correo electronico"
            required
          ></v-text-field>

          <v-select
            v-model="select"
            :items="items"
            :rules="[(v) => !!v || 'Seleccione alguna categoria']"
            label="Categoria"
            required
          ></v-select>

          <v-textarea label="Descripción" variant="solo-filled"></v-textarea>

          <div class="d-flex flex-column">
            <v-btn
              variant="text"
              color="blue"
              class="mt-7"
              block
              @click="validate"
            >
              Enviar
            </v-btn>

            <v-btn variant="text" color="red" class="mt-7" block @click="reset">
              Restablecer formulario
            </v-btn>
          </div>
        </v-form>
      </v-sheet>
    </v-main>
  </v-layout>
</template>
<style scoped>
.custom-heigh {
  height: 100vh;
}

.centered-content {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; /* Opcional: asegura que ocupe el 100% de la altura de la pantalla */
}
</style>