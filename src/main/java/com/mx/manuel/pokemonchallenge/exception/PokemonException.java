package com.mx.manuel.pokemonchallenge.exception;

import org.springframework.http.HttpStatusCode;

import com.mx.manuel.pokemonchallenge.util.ErrorEnum;

import lombok.Getter;

public class PokemonException extends RuntimeException {

	private static final long serialVersionUID = 4661924747779564873L;

	@Getter
	private final HttpStatusCode httpStatus;
    
    @Getter
	private final ErrorEnum errorEnum;

    public PokemonException(HttpStatusCode httpStatus, ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.errorEnum = errorEnum;
        this.httpStatus = httpStatus;
    }
}