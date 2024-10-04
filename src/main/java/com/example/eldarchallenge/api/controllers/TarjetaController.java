package com.example.eldarchallenge.api.controllers;

import com.example.eldarchallenge.api.TarjetaApi;
import com.example.eldarchallenge.dto.Tarjeta;
import com.example.eldarchallenge.service.TarjetaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TarjetaController implements TarjetaApi {

    private final TarjetaService tarjetaService;

    @Override
    public ResponseEntity<String> crearTarjeta(Tarjeta tarjeta) {
        tarjetaService.crearTarjeta(tarjeta);
        return ResponseEntity.ok("Tarjeta creada correctamente");
    }
}
