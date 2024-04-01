//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.03.30 a las 11:22:57 PM CST 
//


package com.mx.manuel.pokemonchallenge.model.soap;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mx.manuel.pokemonchallenge.model.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAbilitiesRequest_QNAME = new QName("https://pokeapi.co/api/v1/pokemon", "getAbilitiesRequest");
    private final static QName _GetBaseExperienceRequest_QNAME = new QName("https://pokeapi.co/api/v1/pokemon", "getBaseExperienceRequest");
    private final static QName _GetHeldItemsRequest_QNAME = new QName("https://pokeapi.co/api/v1/pokemon", "getHeldItemsRequest");
    private final static QName _GetIdRequest_QNAME = new QName("https://pokeapi.co/api/v1/pokemon", "getIdRequest");
    private final static QName _GetNameRequest_QNAME = new QName("https://pokeapi.co/api/v1/pokemon", "getNameRequest");
    private final static QName _GetLocationAreaEncountersRequest_QNAME = new QName("https://pokeapi.co/api/v1/pokemon", "getLocationAreaEncountersRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mx.manuel.pokemonchallenge.model.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReqPokemon }
     * 
     */
    public ReqPokemon createReqPokemon() {
        return new ReqPokemon();
    }

    /**
     * Create an instance of {@link GetAbilitiesResponse }
     * 
     */
    public GetAbilitiesResponse createGetAbilitiesResponse() {
        return new GetAbilitiesResponse();
    }

    /**
     * Create an instance of {@link Ability }
     * 
     */
    public Ability createAbility() {
        return new Ability();
    }

    /**
     * Create an instance of {@link GetBaseExperienceResponse }
     * 
     */
    public GetBaseExperienceResponse createGetBaseExperienceResponse() {
        return new GetBaseExperienceResponse();
    }

    /**
     * Create an instance of {@link GetHeldItemsResponse }
     * 
     */
    public GetHeldItemsResponse createGetHeldItemsResponse() {
        return new GetHeldItemsResponse();
    }

    /**
     * Create an instance of {@link HeldItem }
     * 
     */
    public HeldItem createHeldItem() {
        return new HeldItem();
    }

    /**
     * Create an instance of {@link GetIdResponse }
     * 
     */
    public GetIdResponse createGetIdResponse() {
        return new GetIdResponse();
    }

    /**
     * Create an instance of {@link GetNameResponse }
     * 
     */
    public GetNameResponse createGetNameResponse() {
        return new GetNameResponse();
    }

    /**
     * Create an instance of {@link GetLocationAreaEncountersResponse }
     * 
     */
    public GetLocationAreaEncountersResponse createGetLocationAreaEncountersResponse() {
        return new GetLocationAreaEncountersResponse();
    }

    /**
     * Create an instance of {@link LocationAreaEncounter }
     * 
     */
    public LocationAreaEncounter createLocationAreaEncounter() {
        return new LocationAreaEncounter();
    }

    /**
     * Create an instance of {@link Pokemon }
     * 
     */
    public Pokemon createPokemon() {
        return new Pokemon();
    }

    /**
     * Create an instance of {@link VersionDetail }
     * 
     */
    public VersionDetail createVersionDetail() {
        return new VersionDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     */
    @XmlElementDecl(namespace = "https://pokeapi.co/api/v1/pokemon", name = "getAbilitiesRequest")
    public JAXBElement<ReqPokemon> createGetAbilitiesRequest(ReqPokemon value) {
        return new JAXBElement<ReqPokemon>(_GetAbilitiesRequest_QNAME, ReqPokemon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     */
    @XmlElementDecl(namespace = "https://pokeapi.co/api/v1/pokemon", name = "getBaseExperienceRequest")
    public JAXBElement<ReqPokemon> createGetBaseExperienceRequest(ReqPokemon value) {
        return new JAXBElement<ReqPokemon>(_GetBaseExperienceRequest_QNAME, ReqPokemon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     */
    @XmlElementDecl(namespace = "https://pokeapi.co/api/v1/pokemon", name = "getHeldItemsRequest")
    public JAXBElement<ReqPokemon> createGetHeldItemsRequest(ReqPokemon value) {
        return new JAXBElement<ReqPokemon>(_GetHeldItemsRequest_QNAME, ReqPokemon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     */
    @XmlElementDecl(namespace = "https://pokeapi.co/api/v1/pokemon", name = "getIdRequest")
    public JAXBElement<ReqPokemon> createGetIdRequest(ReqPokemon value) {
        return new JAXBElement<ReqPokemon>(_GetIdRequest_QNAME, ReqPokemon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     */
    @XmlElementDecl(namespace = "https://pokeapi.co/api/v1/pokemon", name = "getNameRequest")
    public JAXBElement<ReqPokemon> createGetNameRequest(ReqPokemon value) {
        return new JAXBElement<ReqPokemon>(_GetNameRequest_QNAME, ReqPokemon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqPokemon }{@code >}
     */
    @XmlElementDecl(namespace = "https://pokeapi.co/api/v1/pokemon", name = "getLocationAreaEncountersRequest")
    public JAXBElement<ReqPokemon> createGetLocationAreaEncountersRequest(ReqPokemon value) {
        return new JAXBElement<ReqPokemon>(_GetLocationAreaEncountersRequest_QNAME, ReqPokemon.class, null, value);
    }

}
