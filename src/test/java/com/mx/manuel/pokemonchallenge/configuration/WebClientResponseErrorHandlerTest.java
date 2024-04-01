package com.mx.manuel.pokemonchallenge.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.mock.http.client.MockClientHttpResponse;

import com.mx.manuel.pokemonchallenge.exception.PokemonException;
import com.mx.manuel.pokemonchallenge.util.ErrorEnum;

public class WebClientResponseErrorHandlerTest {

    WebClientResponseErrorHandler handler = new WebClientResponseErrorHandler();

    @Test
    void hasErrorTest() throws IOException {
        ClientHttpResponse response = new MockClientHttpResponse("{}".getBytes(), HttpStatusCode.valueOf(404));
        boolean isError = handler.hasError(response);
        assertTrue(isError);
    }

    @Test
    void handleError400Test() throws IOException {
        ClientHttpResponse response = new MockClientHttpResponse("{}".getBytes(), HttpStatusCode.valueOf(418));
        PokemonException exception = assertThrows(PokemonException.class, () -> handler.handleError(response));
        assertNotNull(exception);
        assertEquals(ErrorEnum.POK_400, exception.getErrorEnum());
    }

    @Test
    void handleError401Test() throws IOException {
        ClientHttpResponse response = new MockClientHttpResponse("{}".getBytes(), HttpStatusCode.valueOf(401));
        PokemonException exception = assertThrows(PokemonException.class, () -> handler.handleError(response));
        assertNotNull(exception);
        assertEquals(ErrorEnum.POK_401, exception.getErrorEnum());
    }

    @Test
    void handleError404Test() throws IOException {
        ClientHttpResponse response = new MockClientHttpResponse("{}".getBytes(), HttpStatusCode.valueOf(404));
        PokemonException exception = assertThrows(PokemonException.class, () -> handler.handleError(response));
        assertNotNull(exception);
        assertEquals(ErrorEnum.POK_404, exception.getErrorEnum());
    }
}
