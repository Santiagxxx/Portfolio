package com.veterinaria.controller;

import com.veterinaria.dto.TratamientoDTO;
import com.veterinaria.service.TratamientoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {

    private final TratamientoService tratamientoService;

    public TratamientoController(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService;
    }

    @GetMapping
    public List<TratamientoDTO> listar() {
        return tratamientoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TratamientoDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(tratamientoService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<TratamientoDTO> crear(@Valid @RequestBody TratamientoDTO dto) {
        return ResponseEntity.ok(tratamientoService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TratamientoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody TratamientoDTO dto) {
        return ResponseEntity.ok(tratamientoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tratamientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
