
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
  <div>
    <h1>Listado de tickets</h1>
    <li v-for="ticket in tickets" :key="ticket.id_ticket"></li>
      {{ticket.ticket_titulo}}
  </div>
</template>