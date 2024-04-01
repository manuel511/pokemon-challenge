package com.mx.manuel.pokemonchallenge.exception;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import com.mx.manuel.pokemonchallenge.util.ErrorEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoapFaultDefinitionException extends SoapFaultMappingExceptionResolver {

	private static final QName CODE = new QName("code");
	private static final QName MESSAGE = new QName("message");

	@Override
	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
		log.warn("Exception: ", ex);
        SoapFaultDetail detail = fault.addFaultDetail();
		if (ex instanceof PokemonException pokeEx) {
			detail.addFaultDetailElement(CODE).addText(pokeEx.getErrorEnum().getCode());
			detail.addFaultDetailElement(MESSAGE).addText(pokeEx.getErrorEnum().getMessage());
		} else {
            detail.addFaultDetailElement(CODE).addText(ErrorEnum.POK_500.getCode());
			detail.addFaultDetailElement(MESSAGE).addText(ErrorEnum.POK_500.getMessage());
        }
	}

}