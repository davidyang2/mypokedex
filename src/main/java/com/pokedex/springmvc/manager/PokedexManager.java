package com.pokedex.springmvc.manager;

import java.util.List;

import com.pokedex.springmvc.model.Pokedex;
import com.pokedex.springmvc.view.PokedexViewImpl;

public interface PokedexManager {
	
	public PokedexViewImpl createPokedex(PokedexViewImpl pokedex);
	
	public PokedexViewImpl findPokedexById(Long pokedexID);
	
	public Boolean isPokedexExist(PokedexViewImpl pokedex);
	
	public PokedexViewImpl updatePokedex(PokedexViewImpl pokedex);
	
	public void deletePokedexById(Long pokedexID);
	
	public List<PokedexViewImpl> getAllPokedexes();

	public List<PokedexViewImpl> getAllPokedexesByUsername(String username);
}
