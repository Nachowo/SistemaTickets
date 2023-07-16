package com.example.sistematickets.Controllers;

import com.example.sistematickets.Models.Datos;
import com.example.sistematickets.Models.Usuario;
import com.example.sistematickets.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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
    public Map login(@RequestBody Datos datos) {
        String pass = datos.getPass();
        String correo = datos.getCorreo();
        if (usuarioServices.login(correo, pass)) {
            Usuario usuario = usuarioServices.getUsuario(correo);
            Long id = usuario.getId_usuario();
            String rol = usuario.getRol();
            Map<String, Object> retorno = new HashMap<>();
            retorno.put("status", ResponseEntity.ok().build());
            retorno.put("id", usuario.getId_usuario());
            retorno.put("rol",usuario.getRol());
            return retorno;
        }
        Map<String, Object> retorno = new HashMap<>();
        retorno.put("status", ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        return retorno;
    }




}
