package com.mx.manuel.pokemonchallenge.exception;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;

import com.mx.manuel.pokemonchallenge.util.ErrorEnum;

class SoapFaultDefinitionExceptionTest {

    @Test
    void customizeFaultPoekomErrorTest() {
        SoapFaultDefinitionException soapFaul = new SoapFaultDefinitionException();
        SoapFault fault = mock(SoapFault.class);
        SoapFaultDetail detail = mock(SoapFaultDetail.class);
        SoapFaultDetailElement element = mock(SoapFaultDetailElement.class);
        when(fault.addFaultDetail()).thenReturn(detail);
        when(detail.addFaultDetailElement(any())).thenReturn(element);
        soapFaul.customizeFault(null, new PokemonException(HttpStatusCode.valueOf(418), ErrorEnum.POK_500), fault);
        verify(fault).addFaultDetail();
        verify(detail, times(2)).addFaultDetailElement(any());
        verify(element, times(2)).addText(anyString());
    }

    @Test
    void customizeFaultNullErrorTest() {
        SoapFaultDefinitionException soapFaul = new SoapFaultDefinitionException();
        SoapFault fault = mock(SoapFault.class);
        SoapFaultDetail detail = mock(SoapFaultDetail.class);
        SoapFaultDetailElement element = mock(SoapFaultDetailElement.class);
        when(fault.addFaultDetail()).thenReturn(detail);
        when(detail.addFaultDetailElement(any())).thenReturn(element);
        soapFaul.customizeFault(null, new NullPointerException(), fault);
        verify(fault).addFaultDetail();
        verify(detail, times(2)).addFaultDetailElement(any());
        verify(element, times(2)).addText(anyString());
    }
}
