package com.example.eldarchallenge.repository;

import com.example.eldarchallenge.dto.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
}
