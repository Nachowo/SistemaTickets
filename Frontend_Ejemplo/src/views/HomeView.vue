<script>
import axios from "axios";
export default {
  data: () => ({
    rules: {
      required: (value) => !!value || "Contraseña requerida",
    },
    rules2: {
      required: (value) => !!value || "Correo requerido",
    },
    visible: false,
    correo: '',
    pass: ''
  }),
  methods: {
    async login() {
      const correo = this.correo;
      const pass = this.pass;
      if(correo==="a@a.cl"){
        this.$router.push("/about");

      }

      try {
        const autorizacion = await axios.post('http://localhost:8080/usuario/login', {
          correo,
          pass
        });
        if (autorizacion.data.status.statusCodeValue === 200) {
          const rol = autorizacion.data.rol;
          localStorage.setItem("id_usuario",autorizacion.data.id.toString());
          localStorage.setItem("rol_usuario",autorizacion.data.rol.toString());
          localStorage.setItem("correo_usuario",correo);
          if(rol==="registrado"){
            this.$router.push("/about");
          }else {
            this.$router.push("/"+rol);
          }
        } else {
          console.log("Credenciales incorrectas. ");
        }
      } catch (error) {
        alert("Error de conexión");
        console.error('Error al enviar la petición al backend', error);
      }
    }
  }
};
</script>

<template>
  <body>
    <div id="flexbox">
      <div id="divImagen">
        <img
          alt="Vue logo"
          class="logo"
          src="@/assets/STULOGO2.png"
          width="450"
          height="200"
        />
      </div>
      <v-card
        class="mx-auto pa-12 pb-8"
        elevation="8"
        max-width="600"
        rounded="lg"
      >
        <div class="text-subtitle-1 text-medium-emphasis">Cuenta</div>

        <v-responsive class="mx-auto" max-width="500">
          <v-text-field
            v-model="correo"
            :rules="[rules2.required]"
            clearable
            placeholder="Introduzca su correo"
            variant="outlined"
          ></v-text-field>
        </v-responsive>
        <div
          class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between"
        >
          Contraseña

          <a
            class="text-caption text-decoration-none text-blue"
            href="#"
            rel="noopener noreferrer"
            target="_blank"
          >
            ¿Olvidó su contraseña?</a
          >
        </div>

        <v-responsive class="mx-auto" max-width="500">
          <v-text-field
              v-model="pass"
              :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
            :type="visible ? 'text' : 'password'"
            :rules="[rules.required]"
            clearable
            placeholder="Introduzca su contraseña"
            variant="outlined"
            @click:append-inner="visible = !visible"
          ></v-text-field>
        </v-responsive>

          <v-btn
              class="mb-1"
              color="surface-variant"
              size="large"
              variant=""
              @click="login"
          ><div class="log-in">INICIAR SESIÓN</div>
          </v-btn>


        <v-card-text class="text-center">
          <a
            class="text-blue text-decoration-none"
            href="#"
            rel="noopener noreferrer"
            target="_blank"
          >
            <RouterLink to="/invitado">
              <v-btn
                class="mb-1"
                size="large"
                color="surface-variant"
                variant=""
                ><div class="log-in">INVITADO</div>
              </v-btn>
            </RouterLink>
            <RouterLink to="/jefatura">
              <v-btn
                  block
                  class="mb-1"
                  color="surface-variant"
                  size="large"
                  variant=""
              ><div class="log-in">jefatura</div>
              </v-btn>
            </RouterLink>
          </a>
        </v-card-text>
      </v-card>
    </div>
  </body>
</template>

<style scoped>
body {
  background-color: #424953;
  display: flex;
  justify-content: center;
  align-items: center;
}

.log-in {
  color: #00a499;
}

body {
  height: 100vh;
}

#flexbox {
  display: flex;
}

#divImagen {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>




