package com.veterinaria.service;

import com.veterinaria.dto.MascotaDTO;
import java.util.List;

public interface MascotaService {
    List<MascotaDTO> listar();
    MascotaDTO obtener(Long id);
    MascotaDTO crear(MascotaDTO dto);
    MascotaDTO actualizar(Long id, MascotaDTO dto);
    void eliminar(Long id);
}

