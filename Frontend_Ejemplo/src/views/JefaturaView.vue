
<script>
import axios from "axios";
export default {
  mounted() {
    this.getTickets();
    },
  methods: {
    async getTickets(){
      try{
        const respuesta = await axios.get('http://localhost:8080/ticket/listarTickets');
        console.log(respuesta);
        this.tickets = respuesta;
      }catch{
        console.log("Error obteniendo tickets");
      }
    }
  },
  data: () => ({
  tickets: []
})
};

</script>
<template>


</template>