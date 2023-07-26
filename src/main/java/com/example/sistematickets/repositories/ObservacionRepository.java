package com.example.sistematickets.repositories;

import com.example.sistematickets.Models.Observacion;
import com.example.sistematickets.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ObservacionRepository extends JpaRepository<Observacion,Long> {

    @Query("SELECT obs FROM Observacion obs where obs.ticket=:id order by obs.fecha DESC LIMIT 1")
    Optional<Observacion> getLastByTicket(@Param("id") Long id);
}
