package com.veterinaria.controller;

import com.veterinaria.dto.CitaDTO;
import com.veterinaria.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<CitaDTO> listar() {
        return citaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crear(@Valid @RequestBody CitaDTO dto) {
        return ResponseEntity.ok(citaService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CitaDTO dto) {
        return ResponseEntity.ok(citaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

