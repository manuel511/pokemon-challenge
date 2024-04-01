package com.mx.manuel.pokemonchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.manuel.pokemonchallenge.mapper.PokemonMapper;
import com.mx.manuel.pokemonchallenge.model.soap.Ability;
import com.mx.manuel.pokemonchallenge.model.soap.HeldItem;
import com.mx.manuel.pokemonchallenge.model.soap.LocationAreaEncounter;
import com.mx.manuel.pokemonchallenge.repository.IPokeApiRepository;
import com.mx.manuel.pokemonchallenge.util.Constant;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    private IPokeApiRepository repository;

    @Override
    public List<Ability> getAbilities(String name) {

        return repository.getPokemonDataByName(name).getAbilities().stream()
                .map(ability -> PokemonMapper.abilitiesMap(repository.getAbilityByName(ability.getAbility().getName())))
                .toList();
    }

    @Override
    public int getBaseExperience(String name) {
        return repository.getPokemonDataByName(name).getBase_experience();
    }

    @Override
    public List<HeldItem> getHeldItems(String name) {
        return repository.getPokemonDataByName(name).getHeld_items().stream()
                .map(heldItem -> PokemonMapper.heldItemMap(heldItem))
                .toList();
    }

    @Override
    public int getId(String name) {
        return repository.getPokemonDataByName(name).getId();
    }

    @Override
    public boolean getName(String name) {
        repository.getPokemonDataByName(name);
        return true;
    }

    @Override
    public List<LocationAreaEncounter> getLocationAreaEncounters(String name) {
        final String[] url = repository.getPokemonDataByName(name).getLocation_area_encounters().split(Constant.SLASH);
        return repository.getPokemonLocationAreasById(url[url.length - 2]).stream()
                .map(locationAreas -> PokemonMapper.locationAreaEncounterMap(locationAreas))
                .toList();
    }
}
