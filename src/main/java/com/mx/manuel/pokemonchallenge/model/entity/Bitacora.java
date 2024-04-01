package com.mx.manuel.pokemonchallenge.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bitacora_aop")
public class Bitacora implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String ip;
    private LocalDateTime creationDate;
    private String method;
}
