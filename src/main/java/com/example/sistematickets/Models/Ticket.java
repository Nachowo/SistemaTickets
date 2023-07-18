package com.example.sistematickets.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id_ticket;
    private Long solicitante;
    private Long analista;
    private String categoria;
    private int prioridad;
    private String estado;
    private String titulo;
    private String descripcion;
    private String correo;

    public Ticket crearSolicitud(Long solicitante,String correo,String titulo,String categoria, String descripcion){
        this.setTitulo(titulo);
        this.setCorreo(correo);
        this.setSolicitante(solicitante);
        this.setCategoria(categoria);
        this.setDescripcion(descripcion);
        this.setEstado("pendiente");
        this.setPrioridad(1);
        System.out.println(this);
        return this;
    }
    public Ticket crearSolicitudInv(Long id,String correo,String titulo,String categoria, String descripcion){
        this.setTitulo(titulo);
        //this.setSolicitante(solicitante);
        this.setCategoria(categoria);
        this.setDescripcion(descripcion);
        this.setEstado("pendiente");
        this.setPrioridad(1);
        return this;
    }

}



