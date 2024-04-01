package com.mx.manuel.pokemonchallenge.mapper;

import com.mx.manuel.pokemonchallenge.model.pokeapi.ability.ResponseAbility;
import com.mx.manuel.pokemonchallenge.model.pokeapi.encounters.ResponseLocationAreas;
import com.mx.manuel.pokemonchallenge.model.pokeapi.pokemon.PokemonHeldItem;
import com.mx.manuel.pokemonchallenge.model.soap.Ability;
import com.mx.manuel.pokemonchallenge.model.soap.HeldItem;
import com.mx.manuel.pokemonchallenge.model.soap.LocationAreaEncounter;
import com.mx.manuel.pokemonchallenge.model.soap.ObjectFactory;
import com.mx.manuel.pokemonchallenge.model.soap.Pokemon;
import com.mx.manuel.pokemonchallenge.model.soap.VersionDetail;
import com.mx.manuel.pokemonchallenge.util.Constant;

public class PokemonMapper {

    private static final ObjectFactory objectFactory = new ObjectFactory();

    public static Ability abilitiesMap(ResponseAbility pokeAbility) {
        final Ability abilityResp = objectFactory.createAbility();
        abilityResp.setId(pokeAbility.getId());
        abilityResp.setName(pokeAbility.getName());
        abilityResp.setGeneration(pokeAbility.getGeneration().getName());
        abilityResp.setIsMainSeries(pokeAbility.is_main_series());
        pokeAbility.getEffect_entries().stream().filter(effect -> effect.getLanguage().getName().equals(Constant.EN)).findAny()
                .ifPresent(effect -> abilityResp.setEffect(effect.getEffect()));
        abilityResp.getPokemons().addAll(pokeAbility.getPokemon().stream().map(pokemon -> {
            final Pokemon pokemonResp = objectFactory.createPokemon();
            pokemonResp.setId(getId(pokemon.getPokemon().getUrl()));
            pokemonResp.setName(pokemon.getPokemon().getName());
            pokemonResp.setIsHidden(pokemon.is_hidden());
            return pokemonResp;
        }).toList());
        return abilityResp;
    }

    public static HeldItem heldItemMap(PokemonHeldItem pokeHeldItem) {
        final HeldItem heldItemResp = objectFactory.createHeldItem();
        
        heldItemResp.setId(getId(pokeHeldItem.getItem().getUrl()));
        heldItemResp.setName(pokeHeldItem.getItem().getName());
        heldItemResp.getVersion().addAll(pokeHeldItem.getVersion_details().stream().map(detail -> detail.getVersion().getName()).toList());
        return heldItemResp;
    }

    public static LocationAreaEncounter locationAreaEncounterMap(ResponseLocationAreas pokeLocationAreas) {
        final LocationAreaEncounter locationAreaEncounterResp = objectFactory.createLocationAreaEncounter();
        locationAreaEncounterResp.setId(getId(pokeLocationAreas.getLocation_area().getUrl()));
        locationAreaEncounterResp.setName(pokeLocationAreas.getLocation_area().getName());
        locationAreaEncounterResp.getVersionDetails().addAll(pokeLocationAreas.getVersion_details().stream().map(detail -> {
            final VersionDetail versionResp = objectFactory.createVersionDetail();
            versionResp.setId(getId(detail.getVersion().getUrl()));
            versionResp.setName(detail.getVersion().getName());
            versionResp.setMaxChance(detail.getMax_chance());
            return versionResp;
        }).toList());
        return locationAreaEncounterResp;
    }

    private static int getId(String urlString) {
        final String[] url = urlString.split(Constant.SLASH);
        return Integer.valueOf(url[url.length - 1]);
    }
}
