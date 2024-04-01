package com.mx.manuel.pokemonchallenge.model.pokeapi.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NamedAPIResource implements Serializable {
    
    private static final long serialVersionUID = -2136105458144570942L;
	private String name;
    private String url;
}
