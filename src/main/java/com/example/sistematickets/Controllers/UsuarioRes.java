package com.example.sistematickets.Controllers;

import com.example.sistematickets.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Usuario")
public class UsuarioRes {
    @Autowired
    private UsuarioServices usuarioServices;

}
