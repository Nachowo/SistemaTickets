<template>
  <v-app>
    <v-main>
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
                    <th class="text-left py-4">ACCIONES</th>
                  </tr>
                </thead>
                <tbody>
                  <tr
                    v-for="(ticket, index) in historialTickets"
                    :key="ticket.id"
                    :class="index % 2 === 1 ? 'color-intermedio' : ''"
                  >
                    <td class="text-left py-4">{{ ticket.id }}</td>
                    <td class="text-left py-4">{{ ticket.nombre }}</td>
                    <td class="text-left py-4">{{ ticket.fecha }}</td>
                    <td class="text-left py-4">{{ ticket.categoria }}</td>
                    <td>
                      <v-icon small @click="verDetalle(ticket)" class="icon"
                        >mdi-eye</v-icon
                      >
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
</template>

<script>
import NavBar from "../components/NavBar.vue";
export default {
  components: {
    NavBar,
  },
  data() {
    return {
      historialTickets: [
        {
          id: 1,
          nombre: "Ticket 1",
          fecha: "2022-01-01",
          categoria: "Soporte",
        },
        {
          id: 2,
          nombre: "Ticket 2",
          fecha: "2022-01-02",
          categoria: "Soporte",
        },
        {
          id: 3,
          nombre: "Ticket 3",
          fecha: "2022-01-03",
          categoria: "Mantención",
        },
        // Agrega aquí más objetos de ticket según tu historial
      ],
    };
  },
  methods: {
    verDetalle(ticket) {
      // Lógica para ver el detalle del ticket
      console.log("Ticket seleccionado:", ticket);
    },
  },
};
</script>

<style scoped>
.v-data-table {
  width: 100%;
  border: 5px solid #000000; /* Agrega un borde a la tabla */
}

.v-data-table thead th {
  white-space: normal;
  border-bottom: 1px solid #000000; /* Agrega un borde inferior a las celdas del encabezado */
}

.v-data-table tbody td {
  white-space: nowrap;
  border-bottom: 1px solid #000000; /* Agrega un borde inferior a las celdas del cuerpo */
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
