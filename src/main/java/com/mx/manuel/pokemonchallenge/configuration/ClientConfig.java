package com.mx.manuel.pokemonchallenge.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Value("${pokeApi.host}")
    private String pokeApiBaseUrl;
    
    @Bean
    public RestClient pokeApiClient() {
        return RestClient.builder().baseUrl(pokeApiBaseUrl)
        .defaultStatusHandler(new WebClientResponseErrorHandler())
        .build();
    }
}
