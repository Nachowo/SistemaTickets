package com.example.sistematickets.repositories;

import com.example.sistematickets.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}