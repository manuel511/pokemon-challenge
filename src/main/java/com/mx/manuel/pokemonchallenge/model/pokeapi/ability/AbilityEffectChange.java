package com.mx.manuel.pokemonchallenge.model.pokeapi.ability; 

import java.io.Serializable;
import java.util.List;

import com.mx.manuel.pokemonchallenge.model.pokeapi.common.Effect;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbilityEffectChange implements Serializable {

    private List<Effect> effect_entries;
    private NamedAPIResource version_group;
}
