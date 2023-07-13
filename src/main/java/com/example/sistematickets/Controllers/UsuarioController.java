package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/usuario/crear")
    public void crear(@RequestBody Usuario usuario) {
        usuarioServices.guardarUsuario(usuario);
    }


    @PostMapping("/usuario/login")
    public ResponseEntity<?> login(@RequestParam String correo, @RequestParam String pass) {
        if (usuarioServices.login(correo, pass)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
