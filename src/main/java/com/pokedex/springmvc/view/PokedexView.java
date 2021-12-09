package com.pokedex.springmvc.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokedex.springmvc.model.User;

public interface PokedexView {
	
	public Long getId();
 
    public void setId(Long id);
    
    public String getName();
    
    public void setName(String name);
 
    public String getGame();
 
    public void setGame(String game);
    
    public boolean getRegionality();
 
    public void setRegionality(boolean regionality);
    
    public boolean getShiny();
 
    public void setShiny(boolean shiny);
    
    public UserView getUser();
    
    public void setUser(UserView pUser);
}
