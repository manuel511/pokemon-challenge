package com.mx.manuel.pokemonchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class PokemonChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonChallengeApplication.class, args);
	}

}
