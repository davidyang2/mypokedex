package com.pokedex.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.springmvc.dao.PokemonDao;
import com.pokedex.springmvc.model.Pokemon;

@Service("pokemonService")
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private PokemonDao dao;
	
	public Pokemon findByName(String name) {
		return dao.findByName(name);
	}

	public int deletePokemonByName(String name) {
		return dao.deletePokemonByName(name);
	}

	public List<Pokemon> findAllPokemon() {
		return dao.findAllPokemon();
	}

	public Pokemon updatePokemon(Pokemon pokemon) {
		return dao.updatePokemon(pokemon);
	}

}
