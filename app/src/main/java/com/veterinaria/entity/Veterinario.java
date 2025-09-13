package com.veterinaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter @Setter
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String telefono;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;
}
