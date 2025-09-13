package com.veterinaria.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CitaDTO {

    private Long id;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser hoy o futura")
    private LocalDate fecha;

    @NotBlank(message = "El motivo es obligatorio")
    private String motivo;

    @NotNull(message = "La mascota es obligatoria")
    private Long mascotaId; // relación con Mascota

    @NotNull(message = "El veterinario es obligatorio")
    private Long veterinarioId; // relación con Veterinario
}

