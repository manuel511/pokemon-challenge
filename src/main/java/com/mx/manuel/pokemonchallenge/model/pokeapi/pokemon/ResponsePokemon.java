package com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePokemon implements Serializable {

	private static final long serialVersionUID = 1129286726192389580L;
	private Integer id;
    private String name;
    private Integer base_experience;
    private String location_area_encounters;
    private List<PokemonAbility> abilities;
    private List<PokemonHeldItem> held_items;
}
