package com.veterinaria.controller;

import com.veterinaria.dto.MascotaDTO;
import com.veterinaria.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<MascotaDTO> listar() {
        return mascotaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<MascotaDTO> crear(@Valid @RequestBody MascotaDTO dto) {
        return ResponseEntity.ok(mascotaService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaDTO> actualizar(@PathVariable Long id, @Valid @RequestBody MascotaDTO dto) {
        return ResponseEntity.ok(mascotaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

