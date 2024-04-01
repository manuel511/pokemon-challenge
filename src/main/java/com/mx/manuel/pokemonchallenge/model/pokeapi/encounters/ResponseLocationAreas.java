package com.mx.manuel.pokemonchallenge.model.pokeapi.encounters;

import java.io.Serializable;
import java.util.List;

import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.VersionEncounterDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseLocationAreas implements Serializable {

	private static final long serialVersionUID = 2683084050569983742L;
	private NamedAPIResource location_area;
    private List<VersionEncounterDetail> version_details;
}
