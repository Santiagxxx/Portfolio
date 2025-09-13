package com.veterinaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @OneToMany(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos;
}
