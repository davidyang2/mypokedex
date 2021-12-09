package com.pokedex.springmvc.service;

import java.util.List;

import com.pokedex.springmvc.model.Pokemon;

public interface PokemonService {
	
	public Pokemon findByName(String name);
	
	public int deletePokemonByName(String name);
	
	public List<Pokemon> findAllPokemon();
	
	public Pokemon updatePokemon(Pokemon pokemon);
}
