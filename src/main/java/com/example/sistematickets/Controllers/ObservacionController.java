package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Observacion;
import com.example.sistematickets.Models.Ticket;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.Services.ObservacionService;
import com.example.sistematickets.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("Observaciones")


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
}
