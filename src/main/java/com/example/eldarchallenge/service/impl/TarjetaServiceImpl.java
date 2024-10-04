package com.example.eldarchallenge.service.impl;

import com.example.eldarchallenge.dto.Tarjeta;
import com.example.eldarchallenge.exceptions.DataNotFoundException;
import com.example.eldarchallenge.exceptions.TarjetaInvalidaException;
import com.example.eldarchallenge.repository.TarjetaRepository;
import com.example.eldarchallenge.service.MailService;
import com.example.eldarchallenge.service.TarjetaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TarjetaServiceImpl implements TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private final MailService mailService;

    @Override
    public void crearTarjeta(Tarjeta tarjeta) {
        tarjetaRepository.save(tarjeta);
        mailService.sendMail(tarjeta.getCardHolder().getEmail(), "Nueva Tarjeta",
                tarjeta.getCvv() + tarjeta.getNumeroTarjeta());
    }

    @Override
    public List<Tarjeta> getTarjetasPorDni(String dni) {
        return tarjetaRepository.findByCardHolderDni(dni);
    }

    @Override
    public void validarTarjetaCvv(String numeroTarjeta, String cvv) {
        Tarjeta tarjeta = getTarjetaPorNumero(numeroTarjeta);
        if (!tarjeta.getCvv().equals(cvv)) {
            throw new TarjetaInvalidaException("El cvv " + cvv + " no coincide con la tarjeta " + numeroTarjeta);
        }
        if (tarjeta.getFechaVencimiento().isBefore(LocalDate.now())){
            throw new TarjetaInvalidaException("La tarjeta se ecnuentra vencida");
        }
    }

    @Override
    public Tarjeta getTarjetaPorNumero(String numeroTarjeta) {
        return tarjetaRepository.findById(numeroTarjeta)
                .orElseThrow(() -> new DataNotFoundException("No se encontro a la tarjeta " + numeroTarjeta));
    }
}
