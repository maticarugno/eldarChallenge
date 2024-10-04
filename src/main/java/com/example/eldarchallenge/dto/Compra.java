package com.example.eldarchallenge.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compraId;

    @NotNull(message = "El numero de tarjeta es obligatorio")
    @ManyToOne
    @JoinColumn(name = "numeroTarjeta")
    private Tarjeta tarjeta;
    @NotBlank(message = "El cvv es obligatorio")
    private String cvvIngresado;
    @NotNull(message = "El monto es obligatorio")
    private double monto;
    @NotBlank(message = "El detalle es obligatorio")
    private String detalle;

}
