package com.example.sistematickets.Services;

import com.example.sistematickets.Models.Ticket;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    /**
     @PostMapping("/Ticket")
     @ResponseBody
     public Ticket crearTicket(@RequestBody Ticket ticket){
     return ticketRepository.save(ticket);
     }
     */
     public void guardarTicket(Ticket ticket){
        ticketRepository.save(ticket);
     }

    public Optional<Ticket> findTicket(Long id){
        return ticketRepository.findById(id);
    }

}
