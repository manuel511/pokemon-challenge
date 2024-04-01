package com.mx.manuel.pokemonchallenge.util;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.manuel.pokemonchallenge.model.entity.PokemonPopularity;
import com.mx.manuel.pokemonchallenge.repository.IPokemonPopularityRepository;

@ExtendWith(MockitoExtension.class)
class PopularityUtilTest {

    @InjectMocks
    PopularityUtil popularity;

    @Mock
    IPokemonPopularityRepository popularityRep;

    @Test
    void addPopularityNewTest() {
        popularity.addPopularity("darkrai");
        verify(popularityRep).findById(anyString());
        verify(popularityRep).save(any());
    }

    @Test
    void addPopularityTest() {
        when(popularityRep.findById(anyString())).thenReturn(Optional.of(new PokemonPopularity()));
        popularity.addPopularity("darkrai");
        verify(popularityRep).findById(anyString());
        verify(popularityRep).save(any());
    }
}
