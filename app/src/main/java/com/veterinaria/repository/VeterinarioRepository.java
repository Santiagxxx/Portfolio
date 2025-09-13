package com.veterinaria.repository;

import com.veterinaria.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}

