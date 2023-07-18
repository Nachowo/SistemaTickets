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
        String titulo = (String) consulta.get("titulo");
        String id_usuario = (String) consulta.get("id_usuario");
        String categoria = (String) consulta.get("categoria");
        String descripcion = (String) consulta.get("descripcion");

        Ticket ticket = new Ticket().crearSolicitud(Long.parseLong(id_usuario),titulo,categoria,descripcion);
        ticketService.guardarTicket(ticket);
        System.out.println("ticket guardado");
        System.out.println(ResponseEntity.ok().build());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/EnviarTicketInv")
    public ResponseEntity<?> RecibirInv(@RequestBody Map<String,Object> consulta){
        String titulo = (String) consulta.get("titulo");
        String correo = (String) consulta.get("id_usuario");
        String categoria = (String) consulta.get("categoria");
        String descripcion = (String) consulta.get("descripcion");

        Ticket ticket = new Ticket().crearSolicitudInv(0L,correo,titulo,categoria,descripcion);
        ticketService.guardarTicket(ticket);
        System.out.println("ticket guardado");
        System.out.println(ResponseEntity.ok().build());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listarTicketsJefatura")
    public List<Ticket> listarTickets(){
        List<Ticket> lista = ticketService.getTicketsNoAsignados();
        return lista;
    }

    @GetMapping("/obtenerTicketsUsuario")
    public List<Ticket> obtenerTicketsUsuario(@RequestParam("id_usuario") String id){
        System.out.println("controlador");
        Long id_usuario = Long.parseLong(id);
        return ticketService.getByUsuario(id_usuario);
    }
}
