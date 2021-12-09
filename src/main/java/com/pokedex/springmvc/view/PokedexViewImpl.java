package com.pokedex.springmvc.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokedexViewImpl implements PokedexView {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("amount")
	private String game;
	
	@JsonProperty("regionality")
	private Boolean regionality;
	
	@JsonProperty("unit")
	private Boolean shiny;
	
	@JsonProperty("pUser")
	private UserView pUser;
	
	public PokedexViewImpl() {}
	
	public PokedexViewImpl(Long id, String name, String game, 
			Boolean regionality, Boolean shiny, UserView pUser) {
		this.id = id;
        this.name = name;
        this.game = game;
        this.regionality = regionality;
        this.shiny = shiny;
        this.pUser = pUser;
	}
    public Long getId() {
        return id; 
    }
 
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
 
    public String getGame() {
        return game;
    }
 
    public void setGame(String game) {
        this.game = game;
    }
    
    public boolean getRegionality() {
        return regionality;
    }
 
    public void setRegionality(boolean regionality) {
        this.regionality = regionality;
    }
    
    public boolean getShiny() {
        return shiny;
    }
 
    public void setShiny(boolean shiny) {
        this.shiny = shiny;
    }
    
    public UserView getUser() {
    	return pUser;
    }
    
    public void setUser(UserView pUser) {
    	this.pUser = pUser;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserView))
            return false;
        PokedexViewImpl other = (PokedexViewImpl) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", game=" + game 
        		+ ", regionality=" + regionality + ", shiny=" + shiny + ", user=" + pUser +"]";
    }
}
