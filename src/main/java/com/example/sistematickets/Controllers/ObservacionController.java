package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Observacion;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.Services.ObservacionService;
import com.example.sistematickets.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@CrossOrigin(origins = "https front")
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

    //funciones de busqueda como obtener

}
