package com.example.sistematickets.Back.Services;

import com.example.sistematickets.Back.Modelo.Usuario;
import com.example.sistematickets.Back.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepo usuarioRepo;

    /**
     *public Usuario create (Usuario usuario){
     *         return UsuarioRepo.save(usuario);
     *
     *     }
     */

    public List<Usuario> getAllUsuarios(){
        return usuarioRepo.findAll();
    }

    public void delete (Usuario usuario){
        usuarioRepo.delete(usuario);
    }

    public Optional<Usuario> find(Long id){
        return usuarioRepo.findById(id);
    }
}
