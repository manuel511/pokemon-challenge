package com.mx.manuel.pokemonchallenge.model.pokeapi.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerboseEffect implements Serializable {

    private static final long serialVersionUID = 690216648040761321L;
	private String effect;
    private String short_effect;
    private NamedAPIResource language;
}
