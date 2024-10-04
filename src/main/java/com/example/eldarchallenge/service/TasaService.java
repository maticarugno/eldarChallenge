package com.example.eldarchallenge.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface TasaService {
    double calcularTasa(String marcaTarjeta, double importe);
    double calcularTasaPorFecha(String marcaTarjeta, LocalDate fecha);
}
