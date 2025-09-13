package com.veterinaria.repository;

import com.veterinaria.entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
}
