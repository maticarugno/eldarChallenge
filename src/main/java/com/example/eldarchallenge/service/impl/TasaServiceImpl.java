package com.example.eldarchallenge.service.impl;

import com.example.eldarchallenge.dto.marcas.Amex;
import com.example.eldarchallenge.dto.marcas.MarcaTarjeta;
import com.example.eldarchallenge.dto.marcas.Nara;
import com.example.eldarchallenge.dto.marcas.Visa;
import com.example.eldarchallenge.enums.MarcasTarjetas;
import com.example.eldarchallenge.exceptions.MarcaNoReconocidaException;
import com.example.eldarchallenge.service.TasaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TasaServiceImpl implements TasaService {
    @Override
    public double calcularTasa(String marcaTarjeta, double importe) {
        MarcaTarjeta marca = getMarcaTarjeta(marcaTarjeta);
        double tasaTarjeta = marca.calcularTasa(LocalDate.now());
        return (importe * tasaTarjeta) / 100;
    }

    @Override
    public double calcularTasaPorFecha(String marcaTarjeta, LocalDate fecha) {
        MarcaTarjeta marca = getMarcaTarjeta(marcaTarjeta);
        return marca.calcularTasa(fecha);
    }

    private MarcaTarjeta getMarcaTarjeta(String marcaTarjeta) {
        switch (MarcasTarjetas.fromString(marcaTarjeta)) {
            case VISA -> {
                return new Visa();
            }
            case NARA -> {
                return new Nara();
            }
            case AMEX -> {
                return new Amex();
            }
            default -> throw new MarcaNoReconocidaException("Marca de Tarjeta incorrecta");
        }
    }
}
