package com.example.sistematickets.repositories;

import com.example.sistematickets.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query ("SELECT all FROM Ticket all WHERE all.analista=NULL ")
    List<Ticket> getTicketNoAsignado();

    @Query ("SELECT all FROM Ticket all WHERE all.solicitante= :usuario ORDER BY all.id_ticket ")
    List<Ticket> getByUser(@Param("usuario") Long usuario);

    @Query ("SELECT all FROM Ticket all WHERE all.analista= :usuario")
    List<Ticket> getByAnalista(@Param("usuario") Long usuario);

}