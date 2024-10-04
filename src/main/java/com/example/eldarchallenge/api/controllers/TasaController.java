package com.example.eldarchallenge.api.controllers;

import com.example.eldarchallenge.api.TasaApi;
import com.example.eldarchallenge.service.TasaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TasaController implements TasaApi {

    private final TasaService tasaService;

    @Override
    public ResponseEntity<String> consultarTasa(String marca, double importe) {
        double tasa = tasaService.calcularTasa(marca, importe);
        return ResponseEntity.ok(String.valueOf(tasa));
    }
}
