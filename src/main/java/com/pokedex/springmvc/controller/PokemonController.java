package com.pokedex.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pokedex.springmvc.manager.PokemonManager;
import com.pokedex.springmvc.model.Pokemon;
import com.pokedex.springmvc.view.PokemonViewImpl;

@RestController
public class PokemonController {

	@Autowired
	private PokemonManager pokemonManager;
	
	// TODO: Add routing methods
	
	//-------------------Retrieve All Pokemon--------------------------------------------------------
	@RequestMapping(value = "/pokemon", method = RequestMethod.GET)
	public ResponseEntity<List<PokemonViewImpl>> listAllPokedexes(@PathVariable("username") String pokedexName) {
        List<PokemonViewImpl> pokedexes = pokemonManager.findAllPokemon();
        if(pokedexes.isEmpty()){
            return new ResponseEntity<List<PokemonViewImpl>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PokemonViewImpl>>(pokedexes, HttpStatus.OK);
    }
	
	
}
