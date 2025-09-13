package com.veterinaria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TratamientoDTO {

    private Long id;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "El costo es obligatorio")
    @Min(value = 0, message = "El costo no puede ser negativo")
    private Double costo;

    @NotNull(message = "La cita es obligatoria")
    private Long citaId; // relación con Cita
}

