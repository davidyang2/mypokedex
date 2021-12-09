package com.pokedex.springmvc.model;

import java.io.Serializable;

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
public class Pokedex implements Serializable {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Change to Long
    
    @Size(min=1, max=50)
    @Column(name = "NAME", unique = true)
    private String name;
    
    @Column(name = "GAME")
    private String game;
    
    @Column(name = "REGIONALITY")
    private Boolean regionality;
    
    @Column(name = "SHINY")
    private Boolean shiny;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="POKEDEX_USER", referencedColumnName = "USERNAME")
    @JsonBackReference
    private User pUser;
    
    public Pokedex() {}
    
    public Pokedex(Long id, String name, String game, boolean regionality, boolean shiny, User pUser) {
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
    
    public User getUser() {
    	return pUser;
    }
    
    public void setUser(User pUser) {
    	this.pUser = pUser;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", game=" + game 
        		+ ", regionality=" + regionality + ", shiny=" + shiny + ", user=" + pUser +"]";
    }
     
}
