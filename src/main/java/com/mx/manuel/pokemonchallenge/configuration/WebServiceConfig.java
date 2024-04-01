package com.mx.manuel.pokemonchallenge.configuration;

import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.mx.manuel.pokemonchallenge.exception.PokemonException;
import com.mx.manuel.pokemonchallenge.exception.SoapFaultDefinitionException;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/api/v1/pokemon/*");
	}

	@Bean(name = "pokeData")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokeDataSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PokemonPort");
		wsdl11Definition.setLocationUri("/api/v1/pokemon");
		wsdl11Definition.setTargetNamespace("https://pokeapi.co/api/v1/pokemon");
		wsdl11Definition.setSchema(pokeDataSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema pokeDataSchema() {
		return new SimpleXsdSchema(new ClassPathResource("pokeData.xsd"));
	}

	@Bean
	public SoapFaultMappingExceptionResolver exceptionResolver() {
		SoapFaultMappingExceptionResolver exceptionResolver = new SoapFaultDefinitionException();

		SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
		faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
		exceptionResolver.setDefaultFault(faultDefinition);

		Properties errorMappings = new Properties();
		errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
		errorMappings.setProperty(PokemonException.class.getName(), SoapFaultDefinition.CLIENT.toString());
		exceptionResolver.setExceptionMappings(errorMappings);
		exceptionResolver.setOrder(1);
		return exceptionResolver;
	}
}
