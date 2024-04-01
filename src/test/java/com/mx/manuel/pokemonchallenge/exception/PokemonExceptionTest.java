package com.mx.manuel.pokemonchallenge.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;

import com.mx.manuel.pokemonchallenge.util.ErrorEnum;

class PokemonExceptionTest {

    @Test
    void pokemonExceptionTest() {
        PokemonException exception = new PokemonException(HttpStatusCode.valueOf(418), ErrorEnum.POK_400);
        assertNotNull(exception);
        assertEquals(418, exception.getHttpStatus().value());
        assertEquals(ErrorEnum.POK_400, exception.getErrorEnum());
    }
}
