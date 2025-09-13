package com.veterinaria.repository;

import com.veterinaria.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}

