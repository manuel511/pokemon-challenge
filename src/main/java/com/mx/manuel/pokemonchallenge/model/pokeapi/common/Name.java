package com.mx.manuel.pokemonchallenge.model.pokeapi.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name implements Serializable {

    private static final long serialVersionUID = -6978575857835677641L;
	private String name;
    private NamedAPIResource language;
}
