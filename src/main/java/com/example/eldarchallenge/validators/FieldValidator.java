package com.example.eldarchallenge.validators;

import com.example.eldarchallenge.exceptions.InvalidFieldException;

public class FieldValidator {
    public static void validarVacios(String... fields) {
        for (String field : fields) {
            if (field == null || field.isEmpty()) {
                throw new InvalidFieldException("Debe completar todos los campos");
            }
        }
    }
}
