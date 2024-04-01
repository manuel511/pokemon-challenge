package com.mx.manuel.pokemonchallenge.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pokemon_popularity")
public class PokemonPopularity implements Serializable {

	private static final long serialVersionUID = 8209769120894348600L;
	@Id
    private String name;
    private int count;
    private LocalDateTime lastModification;
}
