package com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon;

import java.io.Serializable;

import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonHeldItemVersion implements Serializable {

    private NamedAPIResource version;
    private Integer rarity;
}
