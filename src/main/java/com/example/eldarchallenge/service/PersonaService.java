package com.example.eldarchallenge.service;

import com.example.eldarchallenge.dto.CardHolder;
import org.springframework.stereotype.Service;

@Service
public interface PersonaService {
    void crearPersona(CardHolder cardHolder);
    CardHolder getPersonaPorNombreCompleto(String nombreCompleto);
    CardHolder getPersonaPorDni(String dni);
}
