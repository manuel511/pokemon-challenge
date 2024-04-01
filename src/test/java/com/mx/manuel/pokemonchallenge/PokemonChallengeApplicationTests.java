package com.mx.manuel.pokemonchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class PokemonChallengeApplicationTests {

	 @Test
    void testApplication() {
        MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class);
        utilities.when((MockedStatic.Verification) SpringApplication.run(PokemonChallengeApplication.class, new String[]{})).thenReturn(null);
        PokemonChallengeApplication.main(new String[]{});
        assertEquals(null, SpringApplication.run(PokemonChallengeApplication.class, new String[]{}));
		
    }

}
