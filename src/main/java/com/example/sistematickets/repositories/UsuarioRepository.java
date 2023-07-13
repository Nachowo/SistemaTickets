package com.example.sistematickets.repositories;

import com.example.sistematickets.Models.Usuario;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByCorreo(String correo);
}
