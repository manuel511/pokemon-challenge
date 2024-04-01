package com.mx.manuel.pokemonchallenge.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.manuel.pokemonchallenge.model.soap.GetAbilitiesResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetBaseExperienceResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetHeldItemsResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetIdResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetLocationAreaEncountersResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetNameResponse;
import com.mx.manuel.pokemonchallenge.model.soap.ReqPokemon;
import com.mx.manuel.pokemonchallenge.service.IPokemonService;

@ExtendWith(MockitoExtension.class)
class PokemonEndpointTest {

    @InjectMocks
    PokemonEndpoint endpoint;

    @Mock
    IPokemonService service;

    ReqPokemon request;

    @BeforeEach
    void setup() {
        request = new ReqPokemon();
        request.setPokemon("darkrai");
    }

    @Test
    void getAbilitiesTest() {
        GetAbilitiesResponse resp = endpoint.getAbilities(request);
        assertNotNull(resp);
        assertNotNull(resp.getAbilities());
        assertTrue(resp.getAbilities().isEmpty());
    }

    @Test
    void getBaseExperienceTest() {
        GetBaseExperienceResponse resp = endpoint.getBaseExperience(request);
        assertNotNull(resp);
        assertEquals(0, resp.getBaseExperience());
    }

    @Test
    void getHeldItemsTest() {
        GetHeldItemsResponse resp = endpoint.getHeldItems(request);
        assertNotNull(resp);
        assertNotNull(resp.getHeldItems());
        assertTrue(resp.getHeldItems().isEmpty());
    }

    @Test
    void getIdTest() {
        GetIdResponse resp = endpoint.getId(request);
        assertNotNull(resp);
        assertEquals(0, resp.getId());
    }

    @Test
    void getNameTest() {
        GetNameResponse resp = endpoint.getName(request);
        assertNotNull(resp);
        assertFalse(resp.isIsValid());
    }

    @Test
    void getLocationAreaEncountersTest() {
        GetLocationAreaEncountersResponse resp = endpoint.getLocationAreaEncounters(request);
        assertNotNull(resp);
        assertNotNull(resp.getLocationAreaEncounters());
        assertTrue(resp.getLocationAreaEncounters().isEmpty());
    }
}
