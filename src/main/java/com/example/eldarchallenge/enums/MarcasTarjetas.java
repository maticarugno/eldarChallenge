package com.example.eldarchallenge.enums;

import com.example.eldarchallenge.exceptions.MarcaNoReconocidaException;

public enum MarcasTarjetas {
    VISA,NARA,AMEX;

    public static MarcasTarjetas fromString(String marca) {
        try {
            return MarcasTarjetas.valueOf(marca.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new MarcaNoReconocidaException("Marca no válida: " + marca);
        }
    }
}
