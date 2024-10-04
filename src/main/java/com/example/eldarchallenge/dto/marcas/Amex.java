package com.example.eldarchallenge.dto.marcas;

import java.time.LocalDate;

public class Amex extends MarcaTarjeta{
    @Override
    public double calcularTasa(LocalDate fecha) {
        return Math.max(fecha.getMonthValue() * 0.1, MINIMA_TASA);
    }
}
