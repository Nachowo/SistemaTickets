<script>
  export default {
    data: () => ({
      email: '',
        emailRules: [
        value => {
          if (value) return true

          return 'Se requiere correo electrónico.'
        },
        value => {
          if (/.+@.+\..+/.test(value)) return true

          return 'El correo debe ser válido.'
        },
        
      ],
      select: null,
      items: ['Mantención', 'Soporte'],
      checkbox: false,
    }),

    methods: {
      async validate () {
        const { valid } = await this.$refs.form.validate()

        if (valid) alert('Formulario enviado')
      },
      reset () {
        this.$refs.form.reset()
      },
      resetValidation () {
        this.$refs.form.resetValidation()
      },
    },
  }
</script>

<template>
  <v-layout class="rounded rounded-md">
    <v-app-bar> 
          <v-toolbar>
          <v-avatar class="icon">
            <img alt="Vue logo" class="logo" src="@/assets/STULOGO.png" width="47" height="40" />
          </v-avatar>

          <v-btn variant="plain" to="/about">Inicio</v-btn>
          <v-btn variant="plain" to="/ticket">Ticket</v-btn>
          <v-btn variant="plain" to="/historial">Historial</v-btn>
          <v-spacer></v-spacer> 
          <v-btn variant="plain" to="/">
            Cerrar Sesión
            <v-icon class="icon"><img alt="Cerrar sesión" src="@/assets/cerrar-sesion.png" width="25" height="20" /></v-icon>
          </v-btn>
        </v-toolbar>
    </v-app-bar>
    <v-main>
      <v-sheet width="300" class="mx-auto">
        <v-form ref="form">

          <v-responsive
            class="mb-6"
            max-width="550"
          >
            <v-text-field
                  label="ID"
                  hide-details="auto"
            ></v-text-field>
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
            :rules="[v => !!v || 'Seleccione alguna categoria']"
            label="Categoria"
            required
          ></v-select>

          <v-textarea label="Descripción" variant="solo-filled"></v-textarea>

          <div class="d-flex flex-column">
            <v-btn variant="text"
              color="blue"
              class="mt-7"
              block
              @click="validate"
            >
              Enviar
            </v-btn>

            <v-btn variant="text"
              color="red"
              class="mt-7"
              block
              @click="reset"
            >
              Restablecer formulario
            </v-btn>
          </div>
        </v-form>
      </v-sheet>
    </v-main>
  </v-layout>
</template>

<!--
<script>
  export default {
    data () {
      return {
        dialog: false,
      }
    },

    watch: {
      dialog (val) {
        if (!val) return

        setTimeout(() => (this.dialog = false), 4000)
      },
    },
  }
</script>
<template>

    <v-layout class="rounded rounded-md">
      <v-app-bar> 
          <v-toolbar>
          <v-avatar class="icon">
            <img alt="Vue logo" class="logo" src="@/assets/STULOGO.png" width="47" height="40" />
          </v-avatar>

          <v-btn variant="plain" to="/about">Inicio</v-btn>
          <v-btn variant="plain" to="/ticket">Ticket</v-btn>
          <v-btn variant="plain" to="/historial">Historial</v-btn>
          <v-spacer></v-spacer> 
          <v-btn variant="plain" to="/">
            Cerrar Sesión
            <v-icon class="icon"><img alt="Cerrar sesión" src="@/assets/cerrar-sesion.png" width="25" height="20" /></v-icon>
          </v-btn>
        </v-toolbar>
      </v-app-bar>
      <v-main>
        <v-responsive
            class="mb-6"
            max-width="550"
        >
        <v-text-field
            label="ID"
            hide-details="auto"
         ></v-text-field>
        </v-responsive>

        <v-responsive
            class="mb-6"
            max-width="550"
        >
        <v-text-field
            label="Titulo"
            hide-details="auto"
        ></v-text-field>
        </v-responsive>

        <v-select
            label="Categoria"
            :items="['Mantención', 'Soporte']"
            variant="solo"
        ></v-select>
        <v-responsive
            class="mb-6"
            max-width="550"
        >
        <v-text-field
            hide-details="auto"
            label="Direccion de correo electronico"
            placeholder="Carlos.vera@usach.cl"
            type="email"
        ></v-text-field>
        </v-responsive>

        <v-textarea label="Descripción" variant="solo"></v-textarea>
      </v-main>
    </v-layout>

    <div class="text-center">
        <v-btn
            :disabled="dialog"
            :loading="dialog"
            color="black"
            @click="dialog = true"
        >
        Enviar
        </v-btn>
            <v-dialog
            v-model="dialog"
            :scrim="false"
            persistent
            width="auto"
            >
            <v-card
                color="blue"
            >
            <v-card-text>
            Porfavor espere
            <v-progress-linear
                indeterminate
                color="white"
                class="mb-0"
            ></v-progress-linear>
            </v-card-text>
            </v-card>
            </v-dialog>     
    </div>
  </template>
-->
<style>
.icon {
  margin-right: 10px;
  margin-left: 10px;
}
</style>