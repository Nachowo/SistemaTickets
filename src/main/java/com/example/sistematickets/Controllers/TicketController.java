package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Ticket;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("/EnviarTicket")
    public ResponseEntity<?> Recibir(@RequestBody Map<String,Object> consulta){
        String id_usuario = (String) consulta.get("id_usuario");
        String categoria = (String) consulta.get("categoria");
        String descripcion = (String) consulta.get("descripcion");

        Ticket ticket = new Ticket().crearSolicitud(Long.parseLong(id_usuario),categoria,descripcion);
        ticketService.guardarTicket(ticket);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listarTickets")
    public List<Ticket> listarTickets(){
        List<Ticket> lista = ticketService.getAllTickets();
        return lista;
    }
}
