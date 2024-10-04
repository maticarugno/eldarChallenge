package com.example.eldarchallenge.api;

import com.example.eldarchallenge.dto.Persona;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personas")
public interface PersonaApi {
    @PostMapping()
    ResponseEntity<String> crearPersona(@Valid @RequestBody Persona persona);
}
