/**package com.example.sistematickets.Controllers;

import com.example.sistematickets.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Ticket")
public class TicketController {
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
}
**/