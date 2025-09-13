package com.veterinaria.controller;

import com.veterinaria.dto.ClienteDTO;
import com.veterinaria.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

