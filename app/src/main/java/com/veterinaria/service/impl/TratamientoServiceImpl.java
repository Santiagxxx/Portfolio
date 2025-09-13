package com.veterinaria.service.impl;

import com.veterinaria.dto.TratamientoDTO;
import com.veterinaria.entity.Cita;
import com.veterinaria.entity.Tratamiento;
import com.veterinaria.repository.CitaRepository;
import com.veterinaria.repository.TratamientoRepository;
import com.veterinaria.service.TratamientoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    private final TratamientoRepository tratamientoRepo;
    private final CitaRepository citaRepo;

    public TratamientoServiceImpl(TratamientoRepository tratamientoRepo, CitaRepository citaRepo) {
        this.tratamientoRepo = tratamientoRepo;
        this.citaRepo = citaRepo;
    }

    private TratamientoDTO mapToDTO(Tratamiento t) {
        TratamientoDTO dto = new TratamientoDTO();
        dto.setId(t.getId());
        dto.setDescripcion(t.getDescripcion());
        dto.setCosto(t.getCosto());
        dto.setCitaId(t.getCita().getId());
        return dto;
    }

    private Tratamiento mapToEntity(TratamientoDTO dto) {
        Tratamiento t = new Tratamiento();
        t.setId(dto.getId());
        t.setDescripcion(dto.getDescripcion());
        t.setCosto(dto.getCosto());
        Cita c = citaRepo.findById(dto.getCitaId())
                .orElseThrow(() -> new EntityNotFoundException("Cita no encontrada"));
        t.setCita(c);
        return t;
    }

    @Override
    public List<TratamientoDTO> listar() {
        return tratamientoRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TratamientoDTO obtener(Long id) {
        return tratamientoRepo.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Tratamiento no encontrado"));
    }

    @Override
    public TratamientoDTO crear(TratamientoDTO dto) {
        return mapToDTO(tratamientoRepo.save(mapToEntity(dto)));
    }

    @Override
    public TratamientoDTO actualizar(Long id, TratamientoDTO dto) {
        Tratamiento t = tratamientoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tratamiento no encontrado"));
        t.setDescripcion(dto.getDescripcion());
        t.setCosto(dto.getCosto());
        Cita c = citaRepo.findById(dto.getCitaId())
                .orElseThrow(() -> new EntityNotFoundException("Cita no encontrada"));
        t.setCita(c);
        return mapToDTO(tratamientoRepo.save(t));
    }

    @Override
    public void eliminar(Long id) {
        tratamientoRepo.deleteById(id);
    }
}

