package com.example.eldarchallenge.dto.marcas;

import java.time.LocalDate;

public class Nara extends MarcaTarjeta{
    @Override
    public double calcularTasa(LocalDate fecha) {
        return Math.min(fecha.getDayOfMonth() * 0.5, MAXIMA_TASA);
    }
}
