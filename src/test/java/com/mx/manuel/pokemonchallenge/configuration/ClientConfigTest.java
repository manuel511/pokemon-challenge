package com.mx.manuel.pokemonchallenge.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClient;

@ExtendWith(MockitoExtension.class)
class ClientConfigTest {

    @InjectMocks
    ClientConfig clientConfig;

    @Test
    void pokeApiClient() {
        RestClient client = clientConfig.pokeApiClient();
        assertNotNull(client);
    }
}
