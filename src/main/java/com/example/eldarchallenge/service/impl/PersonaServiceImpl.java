package com.example.eldarchallenge.service.impl;

import com.example.eldarchallenge.dto.Persona;
import com.example.eldarchallenge.exceptions.DataNotFoundException;
import com.example.eldarchallenge.repository.PersonaRepository;
import com.example.eldarchallenge.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public void crearPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Persona getPersonaPorNombreCompleto(String nombreCompleto) {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().filter(persona -> persona.getNombreCompleto().equals(nombreCompleto))
                .findFirst().orElseThrow(() -> new DataNotFoundException("No se encontro a la persona " + nombreCompleto));
    }

    @Override
    public Persona getPersonaPorDni(String dni) {
        return personaRepository.findById(dni)
                .orElseThrow(() -> new DataNotFoundException("No se encontro a la persona con dni " + dni));
    }
}
