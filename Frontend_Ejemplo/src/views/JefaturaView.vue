
<script>
import axios from "axios";
export default {
  mounted() {
    this.getTickets();
    },
  methods: {
    async getTickets(){
      try{
        const respuesta = await axios.get('http://localhost:8080/ticket/listarTicketsJefatura');
        console.log(respuesta.data);
        this.tickets = respuesta.data;
      }catch{
        console.log("Error obteniendo tickets");
      }
    },
    print(elemento){
      if(elemento.titulo===null){
        return "ola";
      }else{
        return elemento.titulo;
      }

    },

    async printTicket(ticket){
      try {
        if(ticket.titulo!==null){
          return ticket.titulo;
        }else{
            return "ticket sin titulo";
        }
      }catch{
        return "problema con el ticket";
      }
    },
  },
  data: () => {
    return {
  tickets: []
}
}
};

</script>



<template>
  <v-layout class="rounded rounded-md centered-layout">
    <div class="centered-message">
      <p class="titulo">BIENVENIDO AL SISTEMA DE TICKET USACH</p>
      <br>
      <ul>
        <li>
          <p class="descripcion">Este es un servicio que permite gestionar de manera eficiente y efectiva las solicitudes, además de priorizarlas según su importancia, asignando responsables y realizar un seguimiento adecuado para su resolución oportuna.</p>
        </li>
      </ul>
      <br>
      <h1>Listado de tickets</h1>
      <li v-for="ticket in tickets" :key="ticket.id_ticket">
        <p>{{ print(ticket) }}</p>
      </li>
    </div>
    <NavBar />
  </v-layout>
</template>



