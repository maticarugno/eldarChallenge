package com.example.eldarchallenge.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasa")
public interface TasaApi {
    @GetMapping("/calcular")
    ResponseEntity<String> consultarTasa(@RequestParam String marca, @RequestParam double importe);
}
