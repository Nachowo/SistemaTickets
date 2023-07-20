<script>
  import router from "@/router";

  export default {
    data: () => ({
      rules3: {
        required: value => !!value || 'Correo requerido',
      },
      correoInvitado:'',
    }),

    methods:{
      guardarCorreo(){
        console.log(this.correoInvitado);
        localStorage.setItem("correo_usuario",this.correoInvitado);
        localStorage.setItem("rol_usuario","invitado");
        localStorage.setItem("id_usuario","0");
        console.log("paso");
        this.$router.push('/ticket');
      }
    }

  }
</script>

<template> 
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/STULOGO2.png" width="350" height="200" />
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
        v-model="correoInvitado"
      :rules="[rules3.required]"
        clearable=""
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
            @click="guardarCorreo"
            class="mb-1"
            color="surface-variant"
            size="large"
        ><div class="log-in">HACER TICKET</div>
        </v-btn>

    </v-card>
  </div>
</template>

<style scoped>
.log-in { color:   #00A499;
}
</style>