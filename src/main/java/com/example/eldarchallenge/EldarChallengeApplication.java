package com.example.eldarchallenge;

import com.example.eldarchallenge.console.MenuInteractivo;
import com.example.eldarchallenge.service.PersonaService;
import com.example.eldarchallenge.service.TarjetaService;
import com.example.eldarchallenge.service.TasaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EldarChallengeApplication implements CommandLineRunner {

	private final PersonaService personaService;
	private final TarjetaService tarjetaService;
	private final TasaService tasaService;

	public EldarChallengeApplication(PersonaService personaService, TarjetaService tarjetaService, TasaService tasaService) {
		this.personaService = personaService;
		this.tarjetaService = tarjetaService;
        this.tasaService = tasaService;
    }

	public static void main(String[] args) {
		SpringApplication.run(EldarChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//Descomentar para correr local y poder ver el menu interactivo
		//MenuInteractivo menu = new MenuInteractivo(personaService, tarjetaService, tasaService);
		//menu.iniciar();
	}
}
