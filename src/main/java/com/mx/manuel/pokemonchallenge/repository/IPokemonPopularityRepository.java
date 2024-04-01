package com.mx.manuel.pokemonchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.manuel.pokemonchallenge.model.entity.PokemonPopularity;

public interface IPokemonPopularityRepository extends JpaRepository<PokemonPopularity, String> {}