package com.example.eldarchallenge.dto;

import com.example.eldarchallenge.enums.MarcasTarjetas;
import com.example.eldarchallenge.validators.FieldValidator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
public class Tarjeta {
    @NotBlank(message = "El numero de tarjeta es obligatorio")
    @Id
    private String numeroTarjeta;

    @NotNull(message = "La marca es obligatoria")
    private MarcasTarjetas marca;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    private LocalDate fechaVencimiento;

    @NotBlank(message = "El cvv es obligatorio")
    private String cvv;

    @NotNull(message = "La persona es obligatoria")
    @ManyToOne
    @JoinColumn(name = "dni")
    private Persona persona;

    public Tarjeta(String numeroTarjeta, MarcasTarjetas marca, LocalDate fechaVencimiento, String cvv, Persona persona) {
        FieldValidator.validarVacios(numeroTarjeta, cvv);
        this.numeroTarjeta = numeroTarjeta;
        this.marca = marca;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.persona = persona;
    }
}
