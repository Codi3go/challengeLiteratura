package com.proyecto.challenge_literatura_alura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChallengeLiteraturaAluraApplication {

	@Autowired
	private Aplicacion aplicacion;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraturaAluraApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			aplicacion.iniciar();
		};
	}
}
