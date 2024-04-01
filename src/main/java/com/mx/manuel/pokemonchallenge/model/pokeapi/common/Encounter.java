package com.mx.manuel.pokemonchallenge.model.pokeapi.common;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Encounter implements Serializable {

    private Integer min_level;
    private Integer max_level;
    private List<NamedAPIResource> condition_values;
    private Integer chance;
    private NamedAPIResource method;
}
