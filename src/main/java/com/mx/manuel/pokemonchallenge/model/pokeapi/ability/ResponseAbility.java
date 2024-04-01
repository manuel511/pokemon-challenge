package com.mx.manuel.pokemonchallenge.model.pokeapi.ability; 

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.Name;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.VerboseEffect;

import lombok.Getter;
import lombok.Setter; 

@Getter
@Setter
public class ResponseAbility  implements Serializable {

    private Integer id;
    private String name;
    @JsonProperty("is_main_series")
    private boolean is_main_series;
    private NamedAPIResource generation;
    private List<Name> names;
    private List<VerboseEffect> effect_entries;
    private List<AbilityEffectChange> effect_changes;
    private List<AbilityFlavorText> flavor_text_entries;
    private List<AbilityPokemon> pokemon;
}
