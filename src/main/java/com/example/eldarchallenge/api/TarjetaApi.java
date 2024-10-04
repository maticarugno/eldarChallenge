package com.example.eldarchallenge.api;

import com.example.eldarchallenge.dto.Tarjeta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tarjetas")
public interface TarjetaApi {
    @PostMapping()
    ResponseEntity<String> crearTarjeta(@Valid @RequestBody Tarjeta tarjeta);
}
