package com.mx.manuel.pokemonchallenge.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import com.mx.manuel.pokemonchallenge.model.pokeapi.ability.ResponseAbility;
import com.mx.manuel.pokemonchallenge.model.pokeapi.encounters.ResponseLocationAreas;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.ResponsePokemon;

@Repository
public class PokeApiRepository implements IPokeApiRepository {

    @Value("${pokeApi.path.pokemon}")
    private String pokemonPath;

    @Value("${pokeApi.path.ability}")
    private String abilityPath;

    @Value("${pokeApi.path.locationAreas}")
    private String locationAreasPath;

    @Autowired
    private RestClient pokeApiClient;

    @Override
    public ResponsePokemon getPokemonDataByName(String name) {
        return pokeApiClient.get()
        .uri(pokemonPath.concat(name))
        .retrieve()
        .body(ResponsePokemon.class);
    }

    @Override
    public ResponseAbility getAbilityByName(String name) {
        return pokeApiClient.get()
        .uri(abilityPath.concat(name))
        .retrieve()
        .body(ResponseAbility.class);
    }

    @Override
    public List<ResponseLocationAreas> getPokemonLocationAreasById(String id) {
        return pokeApiClient.get()
        .uri(locationAreasPath.replace("{id}", id))
        .retrieve()
        .body(new ParameterizedTypeReference<List<ResponseLocationAreas>>() {});
    }
}
