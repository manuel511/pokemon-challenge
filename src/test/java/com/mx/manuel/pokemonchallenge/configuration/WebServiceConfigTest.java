package com.mx.manuel.pokemonchallenge.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@ExtendWith(MockitoExtension.class)
class WebServiceConfigTest {

    @InjectMocks
    WebServiceConfig webService;

    @Mock
    ApplicationContext context;

    @Test
    void messageDispatcherServletTest() {
        ServletRegistrationBean<MessageDispatcherServlet> servel = webService.messageDispatcherServlet(context);
        assertNotNull(servel);
        assertNotNull(servel.getUrlMappings());
        assertEquals("/api/v1/pokemon/*", servel.getUrlMappings().stream().findAny().get());
    }

    @Test
    void defaultWsdl11DefinitionTest() {
        DefaultWsdl11Definition wsdl = webService.defaultWsdl11Definition(new SimpleXsdSchema(new ClassPathResource("pokeData.xsd")));
        assertNotNull(wsdl);
    }

    @Test
    void pokeDataSchemaTest() {
        XsdSchema wsdl = webService.pokeDataSchema();
        assertNotNull(wsdl);
    }

    @Test
    void exceptionResolverTest() {
        SoapFaultMappingExceptionResolver resolver = webService.exceptionResolver();
        assertNotNull(resolver);
        assertEquals(1, resolver.getOrder());
    }
}
