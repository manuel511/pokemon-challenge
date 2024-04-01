package com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonAbility implements Serializable {

	private static final long serialVersionUID = -296091789733554552L;
	@JsonProperty("is_hidden")
    private boolean is_hidden;
    private Integer slot;
    private NamedAPIResource ability;
}
