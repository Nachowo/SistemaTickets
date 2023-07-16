<script>
import NavBar from "../components/NavBar.vue";
import axios from "axios";

export default {
  components: {
    NavBar,
  },

  data: () => ({
    correo: "",
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
    categoria: null,
    items: ["Mantención", "Soporte"],
    checkbox: false,
    descripcion:''

  }),
  computed:{
    estaRegistrado(){
      return localStorage.getItem("id_usuario")===null;
    },
    getID(){
      return localStorage.getItem("id_usuario");
    }
  },

  methods: {
    async validate() {
      const { valid } = await this.$refs.form.validate();
      await this.send();
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },

    async send(){

      const id_usuario=localStorage.getItem("id_usuario");
      const categoria=this.categoria;
      const descripcion = this.descripcion;
      try {
        const hecho = await axios.post('http://localhost:8080/ticket/EnviarTicket',{id_usuario,categoria,descripcion});
        if(hecho){alert("SE REALIZO EL TICKET");}
      }catch{
        alert("NO SE HIZO EL TICKET");
      }
    }
  },
};
</script>

<template>

  <v-layout class="rounded rounded-md">
    <NavBar />
    <v-main class="custom-heigh centered-content">
      <v-sheet width="1800" class="mx-auto redondo">
        <h2 class="Titulo-FORM">SOLICITUD DE TICKET</h2>
        <v-form ref="form">

          <template v-if="estaRegistrado">
            <v-responsive class="mb-6" max-width="1800">
              <v-text-field label="ID" hide-details="auto"></v-text-field>
            </v-responsive>
          </template>

          <v-text-field
            v-model="correo"
            :rules="emailRules"
            label="Direccion de correo electronico"
            required
          ></v-text-field>

          <v-select
            v-model="categoria"
            :items="items"
            :rules="[(v) => !!v || 'Seleccione alguna categoria']"
            label="Categoria"
            required
          ></v-select>

          <v-textarea v-model="descripcion" label="Descripción" variant="solo-filled"></v-textarea>

          <div class="d-flex flex-column">
            <v-btn
              variant="tonal"
              color="blue"
              class="mt-7"
              block
              @click="validate"
            >
              Enviar
            </v-btn>

            <v-btn variant="tonal" color="red" class="mt-7" block @click="reset">
              Restablecer formulario
            </v-btn>
          </div>
        </v-form>
      </v-sheet>
    </v-main>
  </v-layout>
  <div>
    <p>ID DEL USUARIO: {{getID}}</p>
  </div>
</template>

<style scoped>
.custom-heigh {
  height: 100vh;
}

.centered-content {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.Titulo-FORM {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
  background-color: #EA7600;
  color: #394049;
  border-radius: 10px;
}

.redondo {
  border-radius: 10px;
}
</style>