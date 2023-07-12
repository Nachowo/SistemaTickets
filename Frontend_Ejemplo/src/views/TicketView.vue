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
        <v-avatar> <img alt="Vue logo" class="logo" src="@/assets/STULOGO.png" width="47" height="40" /> </v-avatar>
       
        <v-btn variant="plain" to="/about"> Inicio </v-btn>
        <v-btn variant="plain" to="/ticket"> Ticket </v-btn>
        <v-btn variant="plain"> Historial </v-btn>
         
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