package com.example.eldarchallenge.service;

import com.example.eldarchallenge.dto.Persona;
import org.springframework.stereotype.Service;

@Service
public interface PersonaService {
    void crearPersona(Persona persona);
    Persona getPersonaPorNombreCompleto(String nombreCompleto);
    Persona getPersonaPorDni(String dni);
}
