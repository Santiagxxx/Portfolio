package com.veterinaria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    private String especie;

    @NotBlank(message = "La raza es obligatoria")
    private String raza;

    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edad;

    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId; // relación con Cliente
}

