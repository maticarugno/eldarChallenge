package com.example.eldarchallenge.dto.marcas;

import java.time.LocalDate;

public abstract class MarcaTarjeta {

    protected double MAXIMA_TASA = 5;
    protected double MINIMA_TASA = 0.3;

    public abstract double calcularTasa(LocalDate fecha);
}
