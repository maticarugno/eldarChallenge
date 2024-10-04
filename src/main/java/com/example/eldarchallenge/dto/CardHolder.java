package com.example.eldarchallenge.dto;

import com.example.eldarchallenge.validators.FieldValidator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CardHolder {

    @NotBlank(message = "El dni es obligatorio")
    @Id
    private String dni;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El email es obligatorio")
    private String email;

    public CardHolder(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        FieldValidator.validarVacios(dni, nombre, apellido, email);
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
}
