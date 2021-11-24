package com.pokedex.springmvc.dao;

import java.util.List;

import com.pokedex.springmvc.model.Pokemon;

public interface PokemonDao {
	
	public Pokemon findByName(String name);
	
	public int deletePokemonByName(String name);
	
	public List<Pokemon> findAllPokemon();
	
	public Pokemon updatePokemon(Pokemon pokemon);
}
