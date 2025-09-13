package com.veterinaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;
}
