package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@CrossOrigin(origins = "https front")
@RestController
@RequestMapping("Usuarios")
public class UsuarioController {
    private UsuarioService usuarioServices;
    @Autowired
    public UsuarioController(UsuarioService usuarioServices){
        this.usuarioServices = usuarioServices;
    }
    @PostMapping("/Usuario")
    public void crear(@RequestBody Usuario usuario) {
        usuarioServices.guardarUsuario(usuario);
    }

    //funciones de busqueda como obtener

}
