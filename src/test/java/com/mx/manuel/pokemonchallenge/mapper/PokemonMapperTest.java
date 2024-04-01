package com.mx.manuel.pokemonchallenge.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.manuel.pokemonchallenge.model.pokeapi.ability.ResponseAbility;
import com.mx.manuel.pokemonchallenge.model.pokeapi.encounters.ResponseLocationAreas;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.PokemonHeldItem;
import com.mx.manuel.pokemonchallenge.model.soap.Ability;
import com.mx.manuel.pokemonchallenge.model.soap.HeldItem;
import com.mx.manuel.pokemonchallenge.model.soap.LocationAreaEncounter;

class PokemonMapperTest {
    
    final ObjectMapper mapper = new ObjectMapper();;

    @Test
    void abilitiesMapTest() throws IOException {
        ResponseAbility pokeAbility = mapper.readValue(Files.readString(Paths.get("src","test","resources", "ResponseAbility.json")), ResponseAbility.class);
        Ability response = PokemonMapper.abilitiesMap(pokeAbility);
        
        assertNotNull(response);
        assertEquals(pokeAbility.getId(), response.getId());
        assertEquals(pokeAbility.getName(), response.getName());
        assertEquals(pokeAbility.getGeneration().getName(), response.getGeneration());
        assertEquals(pokeAbility.is_main_series(), response.isIsMainSeries());
        assertEquals(pokeAbility.getEffect_entries().get(0).getEffect(), response.getEffect());
        assertNotNull(response.getPokemons());
        assertEquals(pokeAbility.getPokemon().size(), response.getPokemons().size());
        assertEquals(44, response.getPokemons().get(0).getId());
        assertEquals(pokeAbility.getPokemon().get(0).getPokemon().getName(), response.getPokemons().get(0).getName());
        assertEquals(pokeAbility.getPokemon().get(0).is_hidden(), response.getPokemons().get(0).isIsHidden());
    }

    @Test
    void heldItemMapTest() throws IOException {
        PokemonHeldItem pokeHeldItem = mapper.readValue(Files.readString(Paths.get("src","test","resources", "PokemonHeldItem.json")), PokemonHeldItem.class);
        HeldItem response = PokemonMapper.heldItemMap(pokeHeldItem);
        assertNotNull(response);
        assertEquals(81, response.getId());
        assertEquals(pokeHeldItem.getItem().getName(), response.getName());
        assertEquals(pokeHeldItem.getVersion_details().size(), response.getVersion().size());
        assertEquals(pokeHeldItem.getVersion_details().get(0).getVersion().getName(), response.getVersion().get(0));
    }

    @Test
    void locationAreaEncounterMapTest() throws IOException {
        ResponseLocationAreas pokeLocationAreas = mapper.readValue(Files.readString(Paths.get("src","test","resources", "ResponseLocationAreas.json")), ResponseLocationAreas.class);
        LocationAreaEncounter response = PokemonMapper.locationAreaEncounterMap(pokeLocationAreas);
        assertNotNull(response);
        assertEquals(296, response.getId());
        assertEquals(pokeLocationAreas.getLocation_area().getName(), response.getName());
        assertNotNull(pokeLocationAreas.getVersion_details());
        assertEquals(pokeLocationAreas.getVersion_details().size(), response.getVersionDetails().size());
        assertEquals(15, response.getVersionDetails().get(0).getId());
        assertEquals(pokeLocationAreas.getVersion_details().get(0).getVersion().getName(), response.getVersionDetails().get(0).getName());
        assertEquals(pokeLocationAreas.getVersion_details().get(0).getMax_chance(), response.getVersionDetails().get(0).getMaxChance());
    }
}