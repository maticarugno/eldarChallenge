package com.example.eldarchallenge.api.controllers;

import com.example.eldarchallenge.api.PersonaApi;
import com.example.eldarchallenge.dto.CardHolder;
import com.example.eldarchallenge.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PersonaController implements PersonaApi {

    private final PersonaService personaService;

    @Override
    public ResponseEntity<String> crearPersona(CardHolder cardHolder) {
        personaService.crearPersona(cardHolder);
        return ResponseEntity.ok("Persona creada correctamente");
    }
}
