package com.mx.manuel.pokemonchallenge.util;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.mx.manuel.pokemonchallenge.model.entity.PokemonPopularity;
import com.mx.manuel.pokemonchallenge.repository.IPokemonPopularityRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PopularityUtil {

    @Autowired
    private IPokemonPopularityRepository popularityRep;

    @Async("taskExecutorPopularity")
    public void addPopularity(String name){
        log.debug("Updating popularity {}", name);
        final PokemonPopularity pokemon = popularityRep.findById(name).orElseGet(() -> {
            PokemonPopularity newPokemon = new PokemonPopularity();
            newPokemon.setName(name);
            return newPokemon;
        });
        pokemon.setCount(pokemon.getCount() + 1);
        pokemon.setLastModification(LocalDateTime.now());
        popularityRep.save(pokemon);
    }
}
