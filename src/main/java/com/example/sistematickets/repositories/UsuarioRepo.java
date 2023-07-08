package com.example.sistematickets.repositories;

import com.example.sistematickets.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario,Long> {
}
