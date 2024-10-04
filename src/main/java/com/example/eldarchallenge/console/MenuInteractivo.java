package com.example.eldarchallenge.console;

import com.example.eldarchallenge.dto.CardHolder;
import com.example.eldarchallenge.dto.Tarjeta;
import com.example.eldarchallenge.enums.MarcasTarjetas;
import com.example.eldarchallenge.exceptions.DataNotFoundException;
import com.example.eldarchallenge.exceptions.InvalidFieldException;
import com.example.eldarchallenge.exceptions.MarcaNoReconocidaException;
import com.example.eldarchallenge.service.PersonaService;
import com.example.eldarchallenge.service.TarjetaService;
import com.example.eldarchallenge.service.TasaService;
import jakarta.validation.ConstraintViolationException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuInteractivo {
    private final PersonaService personaService;
    private final TarjetaService tarjetaService;
    private final TasaService tasaService;
    private final Scanner scanner;

    public MenuInteractivo(PersonaService personaService, TarjetaService tarjetaService, TasaService tasaService) {
        this.personaService = personaService;
        this.tarjetaService = tarjetaService;
        this.tasaService = tasaService;
        this.scanner = new Scanner(System.in);
    }


    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    registrarPersona();
                    break;
                case 2:
                    registrarTarjeta();
                    break;
                case 3:
                    consultarTarjetasPorDni();
                    break;
                case 4:
                    consultarTasasPorFecha();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public void mostrarMenu() {
        System.out.println("\n--- Sistema de Operaciones con Tarjetas ---");
        System.out.println("1. Registrar una persona");
        System.out.println("2. Registrar una tarjeta");
        System.out.println("3. Consultar tarjetas asociadas por DNI");
        System.out.println("4. Consultar las tasas por fecha");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void registrarPersona() {
        System.out.println("Ingrese los datos de la persona:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (dd-MM-yyyy): ");
        String fechaNac = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        try {
            LocalDate fechaNacimiento = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            CardHolder persona = new CardHolder(dni, nombre, apellido, fechaNacimiento, email);
            personaService.crearPersona(persona);
            System.out.println("Persona registrada con éxito.");
        }catch (DataNotFoundException | InvalidFieldException ex) {
            System.out.println("Error: " + ex.getMessage());
        }catch (DateTimeParseException ex){
            System.out.println("La fecha debe estar en formato dd-MM-yyyy");
        }
    }

    public void registrarTarjeta() {
        System.out.println("Ingrese los datos de la tarjeta:");
        System.out.print("Marca (VISA, NARA, AMEX): ");
        String marca = scanner.nextLine();
        System.out.print("Número de Tarjeta: ");
        String numeroTarjeta = scanner.nextLine();
        System.out.print("Nombre completo del titular: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Fecha de vencimiento (dd-MM-yyyy): ");
        String fechaVenc = scanner.nextLine();
        System.out.print("CVV (Código de Seguridad): ");
        String cvv = scanner.nextLine();

        try {
            LocalDate fechaVencimiento = LocalDate.parse(fechaVenc, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            CardHolder titular = personaService.getPersonaPorNombreCompleto(nombreCompleto);
            Tarjeta tarjeta = new Tarjeta(numeroTarjeta, MarcasTarjetas.fromString(marca), fechaVencimiento, cvv, titular);
            tarjetaService.crearTarjeta(tarjeta);
            System.out.println("Tarjeta registrada con éxito.");
        }catch (DataNotFoundException | InvalidFieldException | MarcaNoReconocidaException ex){
            System.out.println(ex.getMessage());
        }catch (DateTimeParseException ex){
            System.out.println("La fecha debe estar en formato dd-MM-yyyy");
        }
    }

    public void consultarTarjetasPorDni() {
        System.out.print("Ingrese el DNI de la persona: ");
        String dni = scanner.nextLine();

        List<Tarjeta> tarjetas = tarjetaService.getTarjetasPorDni(dni);
        if (tarjetas.isEmpty()) {
            System.out.println("No se encontraron tarjetas para el dni " + dni);
        }else {
            System.out.println("Tarjetas asociadas:");
            for (Tarjeta tarjeta : tarjetas) {
                System.out.println("Numero Tarjeta: " + tarjeta.getNumeroTarjeta());
                System.out.println("Marca: " + tarjeta.getMarca());
                System.out.println("Fecha de vencimiento: " + tarjeta.getFechaVencimiento());
            }
        }
    }

    public void consultarTasasPorFecha() {
        System.out.print("Ingrese la fecha (dd-MM-yyyy) o presione Enter para usar la fecha actual: ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha;
        if (fechaStr.isEmpty()) {
            fecha = LocalDate.now();
        } else {
            fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        calcularTasasPorFecha(fecha);
    }

    public void calcularTasasPorFecha(LocalDate fecha) {
        System.out.println("Tasas para la fecha " + fecha + ":");
        List<String> marcas = List.of("VISA", "NARA", "AMEX");
        for (String marca : marcas){
            double tasa = tasaService.calcularTasaPorFecha(marca, fecha);
            System.out.println("Tasa " + marca +": " + tasa + "%");
        }
    }
}
