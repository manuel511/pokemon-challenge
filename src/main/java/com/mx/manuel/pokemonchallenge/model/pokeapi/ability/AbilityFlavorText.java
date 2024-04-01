package com.mx.manuel.pokemonchallenge.model.pokeapi.ability;

import java.io.Serializable;

import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbilityFlavorText implements Serializable {
    
    private static final long serialVersionUID = 2416071282350878876L;
	private String flavor_text;
    private NamedAPIResource language;
    private NamedAPIResource version_group;
}
