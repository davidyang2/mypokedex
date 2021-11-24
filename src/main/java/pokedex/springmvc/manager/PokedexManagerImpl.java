package pokedex.springmvc.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.pokedex.springmvc.model.Pokedex;
import com.pokedex.springmvc.service.PokedexServiceImpl;
import com.pokedex.springmvc.view.PokedexViewImpl;

public class PokedexManagerImpl implements PokedexManager {
	
	@Autowired
	private PokedexServiceImpl pokedexService;

	public PokedexViewImpl convertToView(Pokedex pokedex) {
		PokedexViewImpl pokedexView = new PokedexViewImpl();
		BeanUtils.copyProperties(pokedex, pokedexView);
		return pokedexView;
	}
	
	public Pokedex convertToImpl(PokedexViewImpl pokedex) {
		Pokedex pokedexImpl = new Pokedex();
		BeanUtils.copyProperties(pokedex, pokedexImpl);
		return pokedexImpl;
	}
	
	@Override
	public PokedexViewImpl createPokedex(PokedexViewImpl pokedex) {
		Pokedex pokedexImpl = convertToImpl(pokedex);
		Pokedex servicePokedexImpl = pokedexService.createPokedex(pokedexImpl);
		PokedexViewImpl retPokedexView = convertToView(servicePokedexImpl);
		return retPokedexView;
	}

	@Override
	public PokedexViewImpl findPokedexById(Integer pokedexID) {
		Pokedex pokedexImpl = pokedexService.findById(pokedexID);
		PokedexViewImpl pokedexView = convertToView(pokedexImpl);
		return pokedexView;
	}

	@Override
	public Boolean isPokedexExist(PokedexViewImpl pokedex) {
		Pokedex pokedexImpl = convertToImpl(pokedex);
		return pokedexService.isPokedexExist(pokedexImpl);
	}

	@Override
	public PokedexViewImpl updatePokedex(PokedexViewImpl pokedex) {
		Pokedex pokedexImpl = convertToImpl(pokedex);
		Pokedex updatedPokedexImpl = pokedexService.updatePokedex(pokedexImpl);
		PokedexViewImpl pokedexView = convertToView(updatedPokedexImpl);
		return pokedexView;
	}

	@Override
	public void deletePokedexById(Integer pokedexID) {
		pokedexService.deletePokedexById(pokedexID);
	}

	@Override
	public List<PokedexViewImpl> getAllPokedexes() {
		List<Pokedex> pokedexList = pokedexService.findAllPokedexes();
		List<PokedexViewImpl> pokedexViewList = new ArrayList<PokedexViewImpl>();
		for (Pokedex pokedex : pokedexList) {
			PokedexViewImpl pokedexView = new PokedexViewImpl();
			BeanUtils.copyProperties(pokedex, pokedexView);
			pokedexViewList.add(pokedexView);
		}
		return pokedexViewList;
	}
	
	
}
