package com.mx.manuel.pokemonchallenge.model.pokeapi.ability;

import java.io.Serializable;

import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbilityFlavorText implements Serializable {
    
    private String flavor_text;
    private NamedAPIResource language;
    private NamedAPIResource version_group;
}
