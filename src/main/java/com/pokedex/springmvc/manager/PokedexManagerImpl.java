package com.pokedex.springmvc.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.springmvc.model.Pokedex;
import com.pokedex.springmvc.service.PokedexService;
import com.pokedex.springmvc.view.PokedexViewImpl;

@Service("pokedexManager")
public class PokedexManagerImpl implements PokedexManager {
	
	@Autowired
	private PokedexService pokedexService;

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
	public PokedexViewImpl findPokedexById(Long pokedexID) {
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
	public void deletePokedexById(Long pokedexID) {
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

	@Override
	public List<PokedexViewImpl> getAllPokedexesByUsername(String username) {		
		List<Pokedex> pokedexList = pokedexService.findAllPokedexesByUsername(username);
		List<PokedexViewImpl> pokedexViewList = new ArrayList<PokedexViewImpl>();
		for (Pokedex pokedex : pokedexList) {
			PokedexViewImpl pokedexView = new PokedexViewImpl();
			BeanUtils.copyProperties(pokedex, pokedexView);
			pokedexViewList.add(pokedexView);
		}
		return pokedexViewList;
	}
	
	
}
