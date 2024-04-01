package com.mx.manuel.pokemonchallenge.model.pokeapi.ability;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbilityPokemon implements Serializable {

    @JsonProperty("is_hidden")
    private boolean is_hidden;
    private Integer slot;
    private NamedAPIResource pokemon;
}
