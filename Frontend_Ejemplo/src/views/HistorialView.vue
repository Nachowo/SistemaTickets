<template>
  <v-app>
    <v-main class="text-center">
      <NavBar />
      <v-container fluid>

        <v-row justify="center">
          <v-col cols="12">
            <h2 class="text-center">HISTORIAL DE REGISTROS DE TICKETS</h2>
            <v-simple-table class="elevation-1" dense>
              <template v-slot:default>
                <thead>
                  <tr>
                    <th class="text-left py-4">ID</th>
                    <th class="text-left py-4">NOMBRE</th>
                    <th class="text-left py-4">FECHA</th>
                    <th class="text-left py-4">CATEGORÍA</th>
                    <th class="text-left py-4"></th>
                  </tr>
                </thead>
                <tbody>
                  <tr
                    v-for="(ticket, index) in historialTickets"
                    :key="ticket.id"
                    :class="index % 2 === 1 ? 'color-intermedio' : ''"
                  >
                    <td class="text-left py-4">{{ ticket.id_ticket }}</td>
                    <td class="text-left py-4">{{ ticket.titulo }}</td>
                    <td class="text-left py-4">
                      {{ darFormatoFecha(ticket.creacion) }}
                    </td>
                    <td class="text-left py-4">{{ ticket.categoria }}</td>
                    <td>
                      <v-btn
                        block
                        class="mb-1"
                        color="#EA7600"
                        background-color="#394049"
                        @click="
                          this.contenido = ticket;
                          ventanita = true;
                          getObs(ticket);
                        "
                        ><div class="log-in">Revisar ticket</div>
                      </v-btn>
                    </td>
                  </tr>
                </tbody>
              </template>
            </v-simple-table>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
  <div>
    <div v-if="ventanita" class="modal">
      <div class="modal-overlay" @click="ventanita = false"></div>
      <div class="modal-content">
        <div>ID: {{ contenido.id_ticket }}</div>
        <div>Fecha de creación: {{ contenido.creacion }}</div>
        <div>Titulo: {{ contenido.titulo }}</div>
        <div>Descripción: {{ contenido.descripcion }}</div>
        <div>Estado: {{ contenido.estado }}</div>
        <div>Ultima modificación: {{this.obs }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import axios from "axios";
export default {
  components: {
    NavBar,
  },

  data() {
    return {
      contenido: "",
      ventanita: false,
      historialTickets: [],
      obs: '',
    };
  },
  mounted() {
    this.getTickets(localStorage.getItem("id_usuario"));
  },
  methods: {
    darFormatoFecha(fecha) {
      return new Intl.DateTimeFormat("es-ES", {
        dateStyle: "medium",
        timeStyle: "short",
      }).format(new Date(fecha));
    },
    async getObs(ticket){
      try{
        const respuesta = await axios.post(
            "http://localhost:8080/Observaciones/obtenerUltimaObs",
            ticket
        );
        console.log(respuesta.data.tarea);
        this.obs = respuesta.data.tarea;
      }catch{
        this.obs = "error al obtener la ultima modificacion";
      }

    },
    async getTickets(usuario) {
      console.log(usuario);
      try {
        const respuesta = await axios.get(
          "http://localhost:8080/ticket/obtenerTicketsUsuario",
          {
            params: {
              id_usuario: usuario,
            },
          }
        );
        this.historialTickets = respuesta.data;
      } catch {
        console.log("error con los tickets");
      }
    },
  },
};
</script>

<style scoped>
.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 20px;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  box-shadow: 2px 2px rgba(0, 0, 0, 0.5);
  align-items: center;
}

.modal-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 10;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  z-index: 10;
}
.v-data-table {
  width: 100%;
  border: 5px solid #000000;
}

.v-data-table thead th {
  white-space: normal;
  border-bottom: 1px solid #000000;
}

.v-data-table tbody td {
  white-space: nowrap;
  border-bottom: 1px solid #000000;
}

.color-intermedio {
  background-color: #c5f1e4;
}

.py-4 {
  padding: 10px;
}

.icon {
  margin-right: 10px;
  margin-left: 10px;
}
</style>
