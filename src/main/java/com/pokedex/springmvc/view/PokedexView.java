package com.pokedex.springmvc.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokedex.springmvc.model.User;
import com.pokedex.springmvc.model.Pokedex.Game;

public interface PokedexView {
	public enum Game {
		SWORD, SHIELD, SUN, MOON, X, Y, 
		BLACK, WHITE, DIAMOND, PEARL, RUBY, 
		SAPPHIRE, GOLD, SILVER, RED, BLUE;
	}
	
	public Integer getId();
 
    public void setId(Integer id);
    
    public String getName();
    
    public void setName(String name);
 
    public Game getGame();
 
    public void setGame(Game game);
    
    public boolean getRegionality();
 
    public void setRegionality(boolean regionality);
    
    public boolean getShiny();
 
    public void setShiny(boolean shiny);
    
    public UserView getUser();
    
    public void setUser(UserView pUser);
}
