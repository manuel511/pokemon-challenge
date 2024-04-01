package com.mx.manuel.pokemonchallenge.configuration;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.mx.manuel.pokemonchallenge.exception.PokemonException;
import com.mx.manuel.pokemonchallenge.util.ErrorEnum;

public class WebClientResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return httpResponse.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {

        throw switch (httpResponse.getStatusCode().value()) {
            case 401 -> new PokemonException(httpResponse.getStatusCode(), ErrorEnum.POK_401);
            case 404 -> new PokemonException(httpResponse.getStatusCode(), ErrorEnum.POK_404);
            default -> new PokemonException(httpResponse.getStatusCode(), ErrorEnum.POK_400);
        };
    }
}