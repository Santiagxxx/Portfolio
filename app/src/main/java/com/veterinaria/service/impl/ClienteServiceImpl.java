package com.veterinaria.service.impl;

import com.veterinaria.dto.ClienteDTO;
import com.veterinaria.entity.Cliente;
import com.veterinaria.repository.ClienteRepository;
import com.veterinaria.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepo;

    public ClienteServiceImpl(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    private ClienteDTO mapToDTO(Cliente c) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setTelefono(c.getTelefono());
        dto.setCorreo(c.getCorreo());
        return dto;
    }

    private Cliente mapToEntity(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setId(dto.getId());
        c.setNombre(dto.getNombre());
        c.setTelefono(dto.getTelefono());
        c.setCorreo(dto.getCorreo());
        return c;
    }

    @Override
    public List<ClienteDTO> listar() {
        return clienteRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO obtener(Long id) {
        return clienteRepo.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }

    @Override
    public ClienteDTO crear(ClienteDTO dto) {
        Cliente cliente = mapToEntity(dto);
        return mapToDTO(clienteRepo.save(cliente));
    }

    @Override
    public ClienteDTO actualizar(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        cliente.setCorreo(dto.getCorreo());
        return mapToDTO(clienteRepo.save(cliente));
    }

    @Override
    public void eliminar(Long id) {
        clienteRepo.deleteById(id);
    }
}


