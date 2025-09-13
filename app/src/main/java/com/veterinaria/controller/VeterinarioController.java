package com.veterinaria.controller;

import com.veterinaria.dto.VeterinarioDTO;
import com.veterinaria.service.VeterinarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public List<VeterinarioDTO> listar() {
        return veterinarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(veterinarioService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<VeterinarioDTO> crear(@Valid @RequestBody VeterinarioDTO dto) {
        return ResponseEntity.ok(veterinarioService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> actualizar(@PathVariable Long id, @Valid @RequestBody VeterinarioDTO dto) {
        return ResponseEntity.ok(veterinarioService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        veterinarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

