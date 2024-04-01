package com.mx.manuel.pokemonchallenge.repository;

import java.util.List;

import com.mx.manuel.pokemonchallenge.model.pokeapi.ability.ResponseAbility;
import com.mx.manuel.pokemonchallenge.model.pokeapi.encounters.ResponseLocationAreas;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.ResponsePokemon;

public interface IPokeApiRepository {

    ResponsePokemon getPokemonDataByName(String name);

    ResponseAbility getAbilityByName(String name);

    List<ResponseLocationAreas> getPokemonLocationAreasById(String id);
}