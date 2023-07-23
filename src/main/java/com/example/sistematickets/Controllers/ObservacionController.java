package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Observacion;
import com.example.sistematickets.Models.Ticket;
import com.example.sistematickets.Services.ObservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Observaciones")


public class ObservacionController {
    private ObservacionService observacionService;
    @Autowired
    public ObservacionController(ObservacionService observacionService){
        this.observacionService = observacionService;
    }

    @PostMapping("/Usuario")
    public void crear(@RequestBody Observacion observacion) {
        observacionService.guardarObservacion(observacion);
    }

    @PostMapping("/generarObs")
    public ResponseEntity<?> guardarObs(@RequestBody Observacion observacion){
        observacion.setFecha(new Timestamp(System.currentTimeMillis()));
        observacionService.guardarObservacion(observacion);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/obtenerUltimaObs")
    public Optional<Observacion> obtenerObs(@RequestBody Ticket ticket){
        Optional<Observacion> observacion = observacionService.findByTicket(ticket.getId_ticket());
        System.out.println(observacion);
        System.out.println(observacion);
        if (observacion.isEmpty()){
            System.out.println("el ticket no tiene observacion");
            Observacion obs = new Observacion();
            obs.setTarea("El ticket no tiene observaciones");
            return Optional.of(obs);
        }
        System.out.println(observacion);
        return observacion;
    }
}
