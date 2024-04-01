package com.mx.manuel.pokemonchallenge.service;

import java.util.List;

import com.mx.manuel.pokemonchallenge.model.soap.Ability;
import com.mx.manuel.pokemonchallenge.model.soap.HeldItem;
import com.mx.manuel.pokemonchallenge.model.soap.LocationAreaEncounter;

public interface IPokemonService {

    List<Ability> getAbilities(String name);

    int getBaseExperience(String name);

    List<HeldItem> getHeldItems(String name);
    
    int getId(String name);

    boolean getName(String name);

    List<LocationAreaEncounter> getLocationAreaEncounters(String name);
}