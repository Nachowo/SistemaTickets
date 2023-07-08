package com.example.sistematickets.Back.repositories;

import com.example.sistematickets.Back.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario,Long> {
}
