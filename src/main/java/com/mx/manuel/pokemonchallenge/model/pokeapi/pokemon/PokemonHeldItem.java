package com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon;

import java.io.Serializable;
import java.util.List;

import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonHeldItem implements Serializable {

	private static final long serialVersionUID = -1696752296903527034L;
	private NamedAPIResource item;
    private List<PokemonHeldItemVersion> version_details;
}
