package com.veterinaria.service.impl;

import com.veterinaria.dto.MascotaDTO;
import com.veterinaria.entity.Cliente;
import com.veterinaria.entity.Mascota;
import com.veterinaria.repository.ClienteRepository;
import com.veterinaria.repository.MascotaRepository;
import com.veterinaria.service.MascotaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepo;
    private final ClienteRepository clienteRepo;

    public MascotaServiceImpl(MascotaRepository mascotaRepo, ClienteRepository clienteRepo) {
        this.mascotaRepo = mascotaRepo;
        this.clienteRepo = clienteRepo;
    }

    private MascotaDTO mapToDTO(Mascota m) {
        MascotaDTO dto = new MascotaDTO();
        dto.setId(m.getId());
        dto.setNombre(m.getNombre());
        dto.setEspecie(m.getEspecie());
        dto.setRaza(m.getRaza());
        dto.setEdad(m.getEdad());
        dto.setClienteId(m.getCliente().getId());
        return dto;
    }

    private Mascota mapToEntity(MascotaDTO dto) {
        Mascota m = new Mascota();
        m.setId(dto.getId());
        m.setNombre(dto.getNombre());
        m.setEspecie(dto.getEspecie());
        m.setRaza(dto.getRaza());
        m.setEdad(dto.getEdad());
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        m.setCliente(cliente);
        return m;
    }

    @Override
    public List<MascotaDTO> listar() {
        return mascotaRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public MascotaDTO obtener(Long id) {
        return mascotaRepo.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
    }

    @Override
    public MascotaDTO crear(MascotaDTO dto) {
        return mapToDTO(mascotaRepo.save(mapToEntity(dto)));
    }

    @Override
    public MascotaDTO actualizar(Long id, MascotaDTO dto) {
        Mascota m = mascotaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
        m.setNombre(dto.getNombre());
        m.setEspecie(dto.getEspecie());
        m.setRaza(dto.getRaza());
        m.setEdad(dto.getEdad());
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        m.setCliente(cliente);
        return mapToDTO(mascotaRepo.save(m));
    }

    @Override
    public void eliminar(Long id) {
        mascotaRepo.deleteById(id);
    }
}

