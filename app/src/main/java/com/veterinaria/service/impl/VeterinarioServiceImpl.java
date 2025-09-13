package com.veterinaria.service.impl;

import com.veterinaria.dto.VeterinarioDTO;
import com.veterinaria.entity.Veterinario;
import com.veterinaria.repository.VeterinarioRepository;
import com.veterinaria.service.VeterinarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepo;

    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepo) {
        this.veterinarioRepo = veterinarioRepo;
    }

    private VeterinarioDTO mapToDTO(Veterinario v) {
        VeterinarioDTO dto = new VeterinarioDTO();
        dto.setId(v.getId());
        dto.setNombre(v.getNombre());
        dto.setEspecialidad(v.getEspecialidad());
        dto.setTelefono(v.getTelefono());
        return dto;
    }

    private Veterinario mapToEntity(VeterinarioDTO dto) {
        Veterinario v = new Veterinario();
        v.setId(dto.getId());
        v.setNombre(dto.getNombre());
        v.setEspecialidad(dto.getEspecialidad());
        v.setTelefono(dto.getTelefono());
        return v;
    }

    @Override
    public List<VeterinarioDTO> listar() {
        return veterinarioRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public VeterinarioDTO obtener(Long id) {
        return veterinarioRepo.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Veterinario no encontrado"));
    }

    @Override
    public VeterinarioDTO crear(VeterinarioDTO dto) {
        return mapToDTO(veterinarioRepo.save(mapToEntity(dto)));
    }

    @Override
    public VeterinarioDTO actualizar(Long id, VeterinarioDTO dto) {
        Veterinario v = veterinarioRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veterinario no encontrado"));
        v.setNombre(dto.getNombre());
        v.setEspecialidad(dto.getEspecialidad());
        v.setTelefono(dto.getTelefono());
        return mapToDTO(veterinarioRepo.save(v));
    }

    @Override
    public void eliminar(Long id) {
        veterinarioRepo.deleteById(id);
    }
}

