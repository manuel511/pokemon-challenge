package com.mx.manuel.pokemonchallenge.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.RequestHeadersUriSpec;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.mx.manuel.pokemonchallenge.model.pokeapi.ability.ResponseAbility;
import com.mx.manuel.pokemonchallenge.model.pokeapi.encounters.ResponseLocationAreas;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.ResponsePokemon;

@ExtendWith(MockitoExtension.class)
class PokeApiRepositoryTest {

    @InjectMocks
    PokeApiRepository repository;

    @Mock
    RestClient pokeApiClient;

    ResponseSpec retrive = mock(ResponseSpec.class);

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(repository, "pokemonPath", "/api/v2/pokemon/");
        ReflectionTestUtils.setField(repository, "abilityPath", "/api/v2/ability/");
        ReflectionTestUtils.setField(repository, "locationAreasPath", "/api/v2/pokemon/{id}/area");
        RequestHeadersUriSpec requestHeadersUriSpec = mock(RequestHeadersUriSpec.class);
        when(pokeApiClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(retrive);
    }

    @Test
    void getPokemonDataByNameTest(){
        when(retrive.body(eq(ResponsePokemon.class))).thenReturn(new ResponsePokemon());
        ResponsePokemon resp = repository.getPokemonDataByName("darkrai");
        assertNotNull(resp);
    }

    @Test
    void getAbilitybyNameTest(){
        when(retrive.body(eq(ResponseAbility.class))).thenReturn(new ResponseAbility());
        ResponseAbility resp = repository.getAbilityByName("darkrai");
        assertNotNull(resp);
    }

    @Test
    void getPokemonLocationAreasByIdTest(){
        List<ResponseLocationAreas> resp = repository.getPokemonLocationAreasById("darkrai");
        assertNull(resp);
    }
}
