package com.example.eldarchallenge.dto.marcas;

import java.time.LocalDate;

public class Visa extends MarcaTarjeta{
    @Override
    public double calcularTasa(LocalDate fecha) {
        double tasa = (double) (fecha.getYear() % 100) / fecha.getMonthValue();
        return Math.min(Math.max(tasa, MINIMA_TASA), MAXIMA_TASA);
    }
}
