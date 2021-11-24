package com.pokedex.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
import org.springframework.stereotype.Service;

import com.pokedex.springmvc.dao.PokedexDao;
import com.pokedex.springmvc.model.Pokedex;

@Service("pokedexService")
public class PokedexServiceImpl implements PokedexService {
	
    @Autowired
    private PokedexDao dao;
     
    public Pokedex findById(Integer id) {
        return dao.findById(id);
    }
    
    @Transactional
    public Pokedex createPokedex(Pokedex pokedex) {
        return dao.createPokedex(pokedex);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    @Transactional
    public Pokedex updatePokedex(Pokedex pokedex) {
//        Pokedex entity = dao.findById(pokedex.getId());
//        if(entity!=null){
//            entity.setName(pokedex.getName());
//            entity.setGame(pokedex.getGame());
//            entity.setRegionality(pokedex.getRegionality());
//            entity.setShiny(pokedex.getShiny());
//        }
//    	return pokedex;
    	return dao.updatePokedex(pokedex);
    }
    
    @Transactional
    public int deletePokedexByName(String name) {
        return dao.deletePokedexByName(name);
    }
    
    @Transactional
    public int deletePokedexById(Integer id) {
    	return dao.deletePokedexById(id);
    }
    
     
    public List<Pokedex> findAllPokedexes() {
        return dao.findAllPokedexes();
    }
    
    public List<Pokedex> findAllPokedexesByUsername(String username) {
    	return dao.findAllPokedexesByUsername(username);
    }
 
    public Pokedex findByName(String name) {
        return dao.findByName(name);
    }
    
    public Boolean isPokedexExist(Pokedex pokedex) {
    	return dao.isPokedexExist(pokedex);
    }

}
