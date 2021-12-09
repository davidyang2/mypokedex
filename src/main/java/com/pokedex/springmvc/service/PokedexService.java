package com.pokedex.springmvc.service;

import java.util.List;

import com.pokedex.springmvc.model.Pokedex;

public interface PokedexService {

    public Pokedex findById(Long id);
    
    public Pokedex findByName(String name);
     
    public Pokedex createPokedex(Pokedex user);
     
    public Pokedex updatePokedex(Pokedex user);
     
    public int deletePokedexByName(String name);
    
    public int deletePokedexById(Long id);
    
    public Boolean isPokedexExist(Pokedex pokedex);
 
    public List<Pokedex> findAllPokedexes(); 
    
    public List<Pokedex> findAllPokedexesByUsername(String username);
}
