package com.veterinaria.service.impl;

import com.veterinaria.dto.CitaDTO;
import com.veterinaria.entity.Cita;
import com.veterinaria.entity.Mascota;
import com.veterinaria.entity.Veterinario;
import com.veterinaria.repository.CitaRepository;
import com.veterinaria.repository.MascotaRepository;
import com.veterinaria.repository.VeterinarioRepository;
import com.veterinaria.service.CitaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepo;
    private final MascotaRepository mascotaRepo;
    private final VeterinarioRepository veterinarioRepo;

    public CitaServiceImpl(CitaRepository citaRepo, MascotaRepository mascotaRepo, VeterinarioRepository veterinarioRepo) {
        this.citaRepo = citaRepo;
        this.mascotaRepo = mascotaRepo;
        this.veterinarioRepo = veterinarioRepo;
    }

    private CitaDTO mapToDTO(Cita c) {
        CitaDTO dto = new CitaDTO();
        dto.setId(c.getId());
        dto.setFecha(c.getFecha());
        dto.setMotivo(c.getMotivo());
        dto.setMascotaId(c.getMascota().getId());
        dto.setVeterinarioId(c.getVeterinario().getId());
        return dto;
    }

    private Cita mapToEntity(CitaDTO dto) {
        Cita c = new Cita();
        c.setId(dto.getId());
        c.setFecha(dto.getFecha());
        c.setMotivo(dto.getMotivo());
        Mascota m = mascotaRepo.findById(dto.getMascotaId())
                .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
        Veterinario v = veterinarioRepo.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new EntityNotFoundException("Veterinario no encontrado"));
        c.setMascota(m);
        c.setVeterinario(v);
        return c;
    }

    @Override
    public List<CitaDTO> listar() {
        return citaRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CitaDTO obtener(Long id) {
        return citaRepo.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Cita no encontrada"));
    }

    @Override
    public CitaDTO crear(CitaDTO dto) {
        return mapToDTO(citaRepo.save(mapToEntity(dto)));
    }

    @Override
    public CitaDTO actualizar(Long id, CitaDTO dto) {
        Cita c = citaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cita no encontrada"));
        c.setFecha(dto.getFecha());
        c.setMotivo(dto.getMotivo());
        Mascota m = mascotaRepo.findById(dto.getMascotaId())
                .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
        Veterinario v = veterinarioRepo.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new EntityNotFoundException("Veterinario no encontrado"));
        c.setMascota(m);
        c.setVeterinario(v);
        return mapToDTO(citaRepo.save(c));
    }

    @Override
    public void eliminar(Long id) {
        citaRepo.deleteById(id);
    }
}

