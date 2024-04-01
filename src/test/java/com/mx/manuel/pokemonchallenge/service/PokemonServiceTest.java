package com.mx.manuel.pokemonchallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.manuel.pokemonchallenge.model.pokeapi.ability.ResponseAbility;
import com.mx.manuel.pokemonchallenge.model.pokeapi.common.NamedAPIResource;
import com.mx.manuel.pokemonchallenge.model.pokeapi.encounters.ResponseLocationAreas;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.PokemonAbility;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.PokemonHeldItem;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.ResponsePokemon;
import com.mx.manuel.pokemonchallenge.model.soap.Ability;
import com.mx.manuel.pokemonchallenge.model.soap.HeldItem;
import com.mx.manuel.pokemonchallenge.model.soap.LocationAreaEncounter;
import com.mx.manuel.pokemonchallenge.repository.IPokeApiRepository;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @InjectMocks
    PokemonService service;

    @Mock
    IPokeApiRepository repository;

    ResponsePokemon pokemon;
    NamedAPIResource named;

    @BeforeEach
    void setup() {
        pokemon = new ResponsePokemon();
        named = new NamedAPIResource();
        named.setName("name");
        named.setUrl("pokemon/1");
        when(repository.getPokemonDataByName(anyString())).thenReturn(pokemon);
    }

    @Test
    void getAbilities() {
        PokemonAbility pokeAbility = new PokemonAbility();
        pokeAbility.setAbility(named);
        pokemon.setAbilities(List.of(pokeAbility));
        ResponseAbility abilityResp = new ResponseAbility();
        abilityResp.setId(1);
        abilityResp.setGeneration(named);
        abilityResp.setEffect_entries(List.of());
        abilityResp.setPokemon(List.of());
        when(repository.getAbilityByName(anyString())).thenReturn(abilityResp);

        List<Ability> resp = service.getAbilities("darkrai");

        verify(repository).getPokemonDataByName(anyString());
        verify(repository).getAbilityByName(anyString());
        assertNotNull(resp);
        assertNotNull(resp.get(0));
    }

    @Test
    void getBaseExperienceTest() {
        pokemon.setBase_experience(321);
        int resp = service.getBaseExperience("darkrai");

        verify(repository).getPokemonDataByName(anyString());
        assertEquals(321, resp);
    }

    @Test
    void getHeldItemsTest() {
        PokemonHeldItem item = new PokemonHeldItem();
        item.setItem(named);
        pokemon.setHeld_items(List.of(item));
        item.setVersion_details(List.of());
        List<HeldItem> resp = service.getHeldItems("darkrai");

        verify(repository).getPokemonDataByName(anyString());
        assertNotNull(resp);
        assertNotNull(resp.get(0));
    }

    @Test
    void getIdTest() {
        pokemon.setId(123);
        int resp = service.getId("darkrai");

        verify(repository).getPokemonDataByName(anyString());
        assertEquals(123, resp);
    }

    @Test
    void getNameTest() {
        pokemon.setId(123);
        boolean resp = service.getName("darkrai");

        verify(repository).getPokemonDataByName(anyString());
        assertEquals(true, resp);
    }

    @Test
    void getLocationAreaEncountersTest() {
        pokemon.setLocation_area_encounters("pokemon/1/e");
        ResponseLocationAreas areas = new ResponseLocationAreas();
        areas.setLocation_area(named);
        areas.setVersion_details(List.of());
        when(repository.getPokemonLocationAreasById(anyString())).thenReturn(List.of(areas));
        List<LocationAreaEncounter> resp = service.getLocationAreaEncounters("darkrai");

        verify(repository).getPokemonDataByName(anyString());
        verify(repository).getPokemonLocationAreasById(anyString());
        assertNotNull(resp);
        assertNotNull(resp.get(0));
    }
}
