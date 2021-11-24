package pokedex.springmvc.manager;

import java.util.List;

import com.pokedex.springmvc.view.PokemonViewImpl;

public interface PokemonManager {
	
	public PokemonViewImpl findPokemonByName(String name);
	
	public int deletePokemonByName(String name);
	
	public List<PokemonViewImpl> findAllPokemon();
	
	public PokemonViewImpl updatePokemon(PokemonViewImpl pokemon);
}
