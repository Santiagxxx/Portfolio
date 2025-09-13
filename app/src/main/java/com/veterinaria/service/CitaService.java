package com.veterinaria.service;

import com.veterinaria.dto.CitaDTO;
import java.util.List;

public interface CitaService {
    List<CitaDTO> listar();
    CitaDTO obtener(Long id);
    CitaDTO crear(CitaDTO dto);
    CitaDTO actualizar(Long id, CitaDTO dto);
    void eliminar(Long id);
}

