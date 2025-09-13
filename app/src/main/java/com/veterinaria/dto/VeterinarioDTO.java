package com.veterinaria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VeterinarioDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String telefono;
}

