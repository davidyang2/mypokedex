package com.pokedex.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="pokedex")
public class Pokedex {
	
	// TODO: Make this a ref table - make this another table
	public enum Game {
		GALAR, ALOLA, KALOS, UNOVA, SINNOH, HOENN, JOHTO, KANTO
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(min=1, max=50)
    @Column(name = "NAME", unique = true)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "GAME")
    private Game game;
    
    @Column(name = "REGIONALITY")
    private Boolean regionality;
    
    @Column(name = "SHINY")
    private Boolean shiny;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="POKEDEX_USER", referencedColumnName = "USERNAME")
    @JsonBackReference
    private User pUser;
    
    public Pokedex() {}
    
    public Pokedex(Integer id, String name, Game game, boolean regionality, boolean shiny, User pUser) {
        this.id = id;
        this.name = name;
        this.game = game;
        this.regionality = regionality;
        this.shiny = shiny;
        this.pUser = pUser;
    }
    
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
 
    public Game getGame() {
        return game;
    }
 
    public void setGame(Game game) {
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
    
    public User getUser() {
    	return pUser;
    }
    
    public void setUser(User pUser) {
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
        if (!(obj instanceof User))
            return false;
        Pokedex other = (Pokedex) obj;
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
