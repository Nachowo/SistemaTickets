package com.example.sistematickets.Services;

import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @PostMapping("/Usuario")
    @ResponseBody
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioRepo.save(usuario);
    }

     public void guardarUsuario(Usuario usuario){
              usuarioRepo.save(usuario);
    }


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
