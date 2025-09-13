package com.veterinaria.service;

import com.veterinaria.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listar();
    ClienteDTO obtener(Long id);
    ClienteDTO crear(ClienteDTO dto);
    ClienteDTO actualizar(Long id, ClienteDTO dto);
    void eliminar(Long id);
}

