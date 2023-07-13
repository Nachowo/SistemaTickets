package com.example.sistematickets.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private long id_user;
    private String correo;
    private String nombre;
    private String contrasena;
    private String rol;

    public Usuario(String nombre, String correo, String pass,String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = pass;
        this.rol = rol;
    }

    public long getId_user() {
        return id_user;
    }
}
