package pokedex.springmvc.manager;

import java.util.List;
import com.pokedex.springmvc.view.PokedexViewImpl;

public interface PokedexManager {
	
	public PokedexViewImpl createPokedex(PokedexViewImpl pokedex);
	public PokedexViewImpl findPokedexById(Integer pokedexID);
	public Boolean isPokedexExist(PokedexViewImpl pokedex);
	public PokedexViewImpl updatePokedex(PokedexViewImpl pokedex);
	public void deletePokedexById(Integer pokedexID);
	public List<PokedexViewImpl> getAllPokedexes();
}
