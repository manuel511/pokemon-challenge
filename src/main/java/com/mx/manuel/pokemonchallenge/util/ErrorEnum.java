package com.mx.manuel.pokemonchallenge.util;

import lombok.Getter;

public enum ErrorEnum {

    POK_400("POK-400", "Error in the external service"),
    POK_401("POK-401", "Unauthorized"),
    POK_404("POK-404", "Pokemon Not Found"),
    POK_500("POK-500", "Generic error");

    @Getter
    private final String code;
    
    @Getter
    private final String message;

    ErrorEnum(final String code, final String message) {
		this.code = code;
		this.message = message;
	}
}
