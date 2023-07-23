package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Observacion;
import com.example.sistematickets.Models.Ticket;
import com.example.sistematickets.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
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

    @PostMapping("/cancelarTicket")
    public ResponseEntity<?> cancelar(@RequestBody Ticket ticket){
        ticket.setEstado("Cancelado");
        try{
            ticketService.guardarTicket(ticket);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            System.out.println(e);
            return  ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/EnviarTicket")
    public ResponseEntity<?> Recibir(@RequestBody Map<String,Object> consulta){
        String titulo = (String) consulta.get("titulo");
        String id_usuario = (String) consulta.get("id_usuario");
        String categoria = (String) consulta.get("categoria");
        String descripcion = (String) consulta.get("descripcion");
        String correo = (String) consulta.get("correo");
        Timestamp fecha = new Timestamp(System.currentTimeMillis());
        Ticket ticket = new Ticket().crearSolicitud(Long.parseLong(id_usuario),correo,titulo,categoria,descripcion,fecha);
        String id = ticketService.guardarTicket(ticket).getId_ticket().toString();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/EnviarTicketInv")
    public ResponseEntity<?> RecibirInv(@RequestBody Map<String,Object> consulta){
        String titulo = (String) consulta.get("titulo");
        String correo = (String) consulta.get("correo");
        String categoria = (String) consulta.get("categoria");
        String descripcion = (String) consulta.get("descripcion");

        Ticket ticket = new Ticket().crearSolicitudInv(0L,correo,titulo,categoria,descripcion);
        ticketService.guardarTicket(ticket);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listarTicketsJefatura")
    public List<Ticket> listarTickets(){
        return ticketService.getTicketsNoAsignados();
    }

    @PostMapping("/derivarTicket")
    public ResponseEntity<?> derivarTicket(@RequestBody Ticket ticket){
        try{
            ticket.setAnalista(2L);
            Ticket t2 = ticketService.derivar(ticket);
            return new ResponseEntity<>(t2, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/obtenerTicketsUsuario")
    public List<Ticket> obtenerTicketsUsuario(@RequestParam("id_usuario") String id){
        Long id_usuario = Long.parseLong(id);
        return ticketService.getByUsuario(id_usuario);
    }

    @GetMapping("/obtenerTicketsAnalista")
    public List<Ticket> obtenerTicketsAnalista(@RequestParam("analista") String id){
        Long id_usuario = Long.parseLong(id);
        System.out.println(id);
        return ticketService.getByAnalista(id_usuario);
    }

    @PostMapping("/responderTicket")
    public ResponseEntity<?> responder(@RequestBody Ticket ticket){
        ticket.setEstado("Respondido");
        ticketService.guardarTicket(ticket);
        return ResponseEntity.ok().build();
    }
}
