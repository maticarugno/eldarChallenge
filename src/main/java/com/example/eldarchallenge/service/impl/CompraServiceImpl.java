package com.example.eldarchallenge.service.impl;

import com.example.eldarchallenge.dto.Compra;
import com.example.eldarchallenge.dto.Tarjeta;
import com.example.eldarchallenge.exceptions.CompraInvalidaException;
import com.example.eldarchallenge.repository.CompraRepository;
import com.example.eldarchallenge.service.CompraService;
import com.example.eldarchallenge.service.MailService;
import com.example.eldarchallenge.service.TarjetaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final TarjetaService tarjetaService;
    private final MailService mailService;

    private static final double MONTO_MAXIMO = 10000;

    @Override
    public void realizarCompra(Compra compra) {
        Tarjeta tarjeta = tarjetaService.getTarjetaPorNumero(compra.getTarjeta().getNumeroTarjeta());
        tarjetaService.validarTarjetaCvv(tarjeta.getNumeroTarjeta(), compra.getCvvIngresado());
        validarCompra(compra);
        compraRepository.save(compra);
        mailService.sendMail(tarjeta.getCardHolder().getEmail(), "Compra realizada",
                "La compra se realizo correctamente.");
    }

    private void validarCompra(Compra compra) {
        if (compra.getMonto() > MONTO_MAXIMO){
            throw new CompraInvalidaException("El monto de la compra no puede ser mayor a " + MONTO_MAXIMO);
        }
    }
}
