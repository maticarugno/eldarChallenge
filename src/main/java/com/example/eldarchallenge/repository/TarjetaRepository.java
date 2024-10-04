package com.example.eldarchallenge.repository;

import com.example.eldarchallenge.dto.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarjetaRepository extends JpaRepository<Tarjeta, String> {
    List<Tarjeta> findByPersonaDni(String dni);
}
