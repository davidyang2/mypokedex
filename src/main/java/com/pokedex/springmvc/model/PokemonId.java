package com.pokedex.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class PokemonId implements Serializable {
	
	// Composite Primary Key (since number is not always unique)
	@Column(name = "NUMBER")
	private Integer number;
	
	@Size(min=1, max=50)
	@Column(name = "NAME")
	private String name;
	
	public PokemonId(Integer number, String name) {
		this.number = number;
		this.name = name;
	}
}
