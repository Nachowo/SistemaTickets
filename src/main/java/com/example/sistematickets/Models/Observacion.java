package com.example.sistematickets.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Observaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id_observacion;
    private String tarea;
    private String clasificacion;
    private String fecha;
    private Long usuario;

}
