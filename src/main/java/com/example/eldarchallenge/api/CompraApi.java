package com.example.eldarchallenge.api;

import com.example.eldarchallenge.dto.Compra;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compras")
public interface CompraApi {

    @PostMapping()
    ResponseEntity<String> realizarCompra(@Valid @RequestBody Compra compra);
}
