package com.pokedex.springmvc.dao;

import java.util.List;

import com.pokedex.springmvc.model.Pokedex;

public interface PokedexDao {
    public Pokedex findById(Long id);
    
    public Pokedex findByName(String email);
    
    public Pokedex createPokedex(Pokedex pokedex);
     
    public int deletePokedexByName(String name);
    
    public int deletePokedexById(Long id);
    
    public Pokedex updatePokedex(Pokedex pokedex);
    
    public List<Pokedex> findAllPokedexes();
    
    public List<Pokedex> findAllPokedexesByUsername(String pUser);
    
    public Boolean isPokedexExist(Pokedex pokedex);
}
