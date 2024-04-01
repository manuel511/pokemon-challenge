package com.mx.manuel.pokemonchallenge.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mx.manuel.pokemonchallenge.model.soap.GetAbilitiesResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetBaseExperienceResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetHeldItemsResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetIdResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetLocationAreaEncountersResponse;
import com.mx.manuel.pokemonchallenge.model.soap.GetNameResponse;
import com.mx.manuel.pokemonchallenge.model.soap.ObjectFactory;
import com.mx.manuel.pokemonchallenge.model.soap.ReqPokemon;
import com.mx.manuel.pokemonchallenge.service.IPokemonService;

@Endpoint
public class PokemonEndpoint {

	private static final String NAMESPACE_URI = "https://pokeapi.co/api/v1/pokemon";

	private static final ObjectFactory objectFactory = new ObjectFactory();

	@Autowired
	private IPokemonService service;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
	@ResponsePayload
	public GetAbilitiesResponse getAbilities(@RequestPayload ReqPokemon request) {
		final var response = objectFactory.createGetAbilitiesResponse();
		response.getAbilities().addAll(service.getAbilities(request.getPokemon()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
	@ResponsePayload
	public GetBaseExperienceResponse getBaseExperience(@RequestPayload ReqPokemon request) {
		final var response = objectFactory.createGetBaseExperienceResponse();
		response.setBaseExperience(service.getBaseExperience(request.getPokemon()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
	@ResponsePayload
	public GetHeldItemsResponse getHeldItems(@RequestPayload ReqPokemon request) {
		final var response = objectFactory.createGetHeldItemsResponse();
		response.getHeldItems().addAll(service.getHeldItems(request.getPokemon()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
	@ResponsePayload
	public GetIdResponse getId(@RequestPayload ReqPokemon request) {
		final var response = objectFactory.createGetIdResponse();
		response.setId(service.getId(request.getPokemon()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
	@ResponsePayload
	public GetNameResponse getName(@RequestPayload ReqPokemon request) {
		final var response = objectFactory.createGetNameResponse();
		response.setIsValid(service.getName(request.getPokemon()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
	@ResponsePayload
	public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload ReqPokemon request) {
		final var response = objectFactory.createGetLocationAreaEncountersResponse();
		response.getLocationAreaEncounters().addAll(service.getLocationAreaEncounters(request.getPokemon()));
		return response;
	}
}
