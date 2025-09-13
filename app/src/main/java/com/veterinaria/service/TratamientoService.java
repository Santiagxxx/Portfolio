package com.veterinaria.service;

import com.veterinaria.dto.TratamientoDTO;
import java.util.List;

public interface TratamientoService {
    List<TratamientoDTO> listar();
    TratamientoDTO obtener(Long id);
    TratamientoDTO crear(TratamientoDTO dto);
    TratamientoDTO actualizar(Long id, TratamientoDTO dto);
    void eliminar(Long id);
}

