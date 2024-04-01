package com.mx.manuel.pokemonchallenge.model.pokeapi.common;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VersionEncounterDetail implements Serializable {

	private static final long serialVersionUID = -9217071614870419147L;
	private NamedAPIResource version;
    private Integer max_chance;
    private List<Encounter> encounter_details;
}
