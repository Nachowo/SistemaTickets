package com.example.sistematickets.Services;

import com.example.sistematickets.Models.Ticket;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.repositories.TicketRepository;
import com.example.sistematickets.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private UsuarioRepository usuarioRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }


     public Ticket guardarTicket(Ticket ticket){
        return ticketRepository.save(ticket);
     }

    public Optional<Ticket> findTicket(Long id){
        return ticketRepository.findById(id);
    }
    public boolean existsByCorreo(String correo){
         if(getIdByCorreo(correo)!=null){
             return true;
         }
         return false;
    }
    public Usuario getIdByCorreo(String correo){
         return usuarioRepository.findByCorreo(correo);

    }
    public Ticket derivar(Ticket ticket){
        ticket.setEstado("En revision");
        return ticketRepository.save(ticket);

    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
    public List<Ticket> getTicketsNoAsignados(){
        return ticketRepository.getTicketNoAsignado()   ;
    }
    public List<Ticket> getByUsuario(Long usuario){
        return ticketRepository.getByUser(usuario);}

    public List<Ticket> getByAnalista(Long usuario){
        return ticketRepository.getByAnalista(usuario);}
}

