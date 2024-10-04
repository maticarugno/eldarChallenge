package com.example.eldarchallenge.service;

import com.example.eldarchallenge.dto.Compra;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {
    void realizarCompra(Compra compra);
}
