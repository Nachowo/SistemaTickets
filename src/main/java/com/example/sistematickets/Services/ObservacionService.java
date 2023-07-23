package com.example.sistematickets.Services;

import com.example.sistematickets.Models.Observacion;
import com.example.sistematickets.repositories.ObservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Observacion> findByTicket(Long id){return observacionRepository.getLastByTicket(id);}

}