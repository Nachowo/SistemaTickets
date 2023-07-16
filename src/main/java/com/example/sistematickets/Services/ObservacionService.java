package com.example.sistematickets.Services;

import com.example.sistematickets.Models.Observacion;
import com.example.sistematickets.Models.Ticket;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.repositories.ObservacionRepository;
import com.example.sistematickets.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class ObservacionService {

    private final ObservacionRepository observacionRepository;

    @Autowired
    public ObservacionService(ObservacionRepository observacionRepository){
        this.observacionRepository = observacionRepository;
    }

    public void guardarObservacion(Observacion observacion){
        observacionRepository.save(observacion);
    }

    public Optional<Observacion> findObs(Long id){
        return observacionRepository.findById(id);
    }

}