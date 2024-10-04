package com.example.eldarchallenge.api.controllers;

import com.example.eldarchallenge.api.CompraApi;
import com.example.eldarchallenge.dto.Compra;
import com.example.eldarchallenge.service.CompraService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CompraController implements CompraApi {

    private final CompraService compraService;

    @Override
    public ResponseEntity<String> realizarCompra(Compra compra) {
        compraService.realizarCompra(compra);
        return ResponseEntity.ok("Compra realizada correctamente");
    }
}
