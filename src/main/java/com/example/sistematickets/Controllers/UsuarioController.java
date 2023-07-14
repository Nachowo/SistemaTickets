package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Datos;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioServices;
    @Autowired
    public UsuarioController(UsuarioService usuarioServices){
        this.usuarioServices = usuarioServices;
    }
    @PostMapping("/crear")
    public void crear(@RequestBody Usuario usuario) {
        usuarioServices.guardarUsuario(usuario);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Datos datos) {
        System.out.println("ENTRO");
        String pass = datos.getPass();
        String correo = datos.getCorreo();
        System.out.println(usuarioServices.login(correo,pass));
        if (usuarioServices.login(correo, pass)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }




}
