package com.example.eldarchallenge.service;

import com.example.eldarchallenge.dto.Tarjeta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TarjetaService {
    void crearTarjeta(Tarjeta tarjeta);
    List<Tarjeta> getTarjetasPorDni(String dni);
    void validarTarjetaCvv(String numeroTarjeta, String cvv);
    Tarjeta getTarjetaPorNumero(String numeroTarjeta);
}
