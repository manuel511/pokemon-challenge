package com.mx.manuel.pokemonchallenge.model.pokeapi.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Effect implements Serializable {

    private static final long serialVersionUID = -3316388097793328926L;
	private String effect;
    private NamedAPIResource language;
}
