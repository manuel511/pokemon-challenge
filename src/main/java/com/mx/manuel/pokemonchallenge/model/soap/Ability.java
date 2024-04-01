//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.03.30 a las 11:22:57 PM CST 
//


package com.mx.manuel.pokemonchallenge.model.soap;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ability complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ability"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="isMainSeries" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="generation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="effect" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pokemons" type="{https://pokeapi.co/api/v1/pokemon}pokemon" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ability", propOrder = {
    "id",
    "name",
    "isMainSeries",
    "generation",
    "effect",
    "pokemons"
})
public class Ability {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    protected boolean isMainSeries;
    @XmlElement(required = true)
    protected String generation;
    @XmlElement(required = true)
    protected String effect;
    @XmlElement(required = true)
    protected List<Pokemon> pokemons;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad isMainSeries.
     * 
     */
    public boolean isIsMainSeries() {
        return isMainSeries;
    }

    /**
     * Define el valor de la propiedad isMainSeries.
     * 
     */
    public void setIsMainSeries(boolean value) {
        this.isMainSeries = value;
    }

    /**
     * Obtiene el valor de la propiedad generation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneration() {
        return generation;
    }

    /**
     * Define el valor de la propiedad generation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneration(String value) {
        this.generation = value;
    }

    /**
     * Obtiene el valor de la propiedad effect.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffect() {
        return effect;
    }

    /**
     * Define el valor de la propiedad effect.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffect(String value) {
        this.effect = value;
    }

    /**
     * Gets the value of the pokemons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the pokemons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPokemons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pokemon }
     * 
     * 
     */
    public List<Pokemon> getPokemons() {
        if (pokemons == null) {
            pokemons = new ArrayList<Pokemon>();
        }
        return this.pokemons;
    }

}
