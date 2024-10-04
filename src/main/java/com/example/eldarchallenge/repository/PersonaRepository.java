package com.example.eldarchallenge.repository;

import com.example.eldarchallenge.dto.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<CardHolder, String> {
}
