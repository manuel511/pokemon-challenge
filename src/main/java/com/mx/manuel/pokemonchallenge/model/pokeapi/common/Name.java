package com.mx.manuel.pokemonchallenge.model.pokeapi.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name implements Serializable {

    private String name;
    private NamedAPIResource language;
}
