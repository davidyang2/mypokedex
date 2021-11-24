package pokedex.springmvc.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.pokedex.springmvc.model.Pokemon;
import com.pokedex.springmvc.service.PokemonServiceImpl;
import com.pokedex.springmvc.view.PokemonViewImpl;

public class PokemonManagerImpl implements PokemonManager {

	@Autowired
	private PokemonServiceImpl pokemonService;
	
	public PokemonViewImpl convertToView(Pokemon pokemon) {
		PokemonViewImpl pokemonView = new PokemonViewImpl();
		BeanUtils.copyProperties(pokemon, pokemonView);
		return pokemonView;
	}
	
	public Pokemon convertToImpl(PokemonViewImpl pokemon) {
		Pokemon pokemonImpl = new Pokemon();
		BeanUtils.copyProperties(pokemon, pokemonImpl);
		return pokemonImpl;
	}
	
	@Override
	public PokemonViewImpl findPokemonByName(String name) {
		Pokemon pokemonImpl = pokemonService.findByName(name);
		PokemonViewImpl pokemonView = convertToView(pokemonImpl);
		return pokemonView;
	}

	@Override
	public int deletePokemonByName(String name) {
		return pokemonService.deletePokemonByName(name);
	}

	@Override
	public List<PokemonViewImpl> findAllPokemon() {
		List<Pokemon> pokemonList = pokemonService.findAllPokemon();
		List<PokemonViewImpl> pokemonViewList = new ArrayList<PokemonViewImpl>();
		for (Pokemon pokemon : pokemonList) {
			PokemonViewImpl pokemonView = new PokemonViewImpl();
			BeanUtils.copyProperties(pokemon, pokemonView);
			pokemonViewList.add(pokemonView);
		}
		return pokemonViewList;	
	}

	@Override
	public PokemonViewImpl updatePokemon(PokemonViewImpl pokemon) {
		Pokemon pokemonImpl = convertToImpl(pokemon);
		Pokemon updatedPokemonImpl = pokemonService.updatePokemon(pokemonImpl);
		PokemonViewImpl pokemonView = convertToView(updatedPokemonImpl);
		return pokemonView;
	}
	
}
