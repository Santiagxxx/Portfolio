package com.veterinaria.service;

import com.veterinaria.dto.VeterinarioDTO;
import java.util.List;

public interface VeterinarioService {
    List<VeterinarioDTO> listar();
    VeterinarioDTO obtener(Long id);
    VeterinarioDTO crear(VeterinarioDTO dto);
    VeterinarioDTO actualizar(Long id, VeterinarioDTO dto);
    void eliminar(Long id);
}

