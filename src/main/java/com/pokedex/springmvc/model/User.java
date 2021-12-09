package com.pokedex.springmvc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Switch to Long
    
    @Size(min=1, max=50)
    @Column(name = "USERNAME", unique=true)
    private String username;
    
    @Size(min=1, max=50)
    @Column(name = "EMAIL", unique=true)
    private String email;

    @Size(min=7, max=50)
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "SWITCHFC")
    private String switchfc;
    
    @Column(name = "THREEDSFC")
    private String threedsfc;
    
    // @Transaction either on Dao or service layer 
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pUser", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Pokedex> pokedexes;
     
    public User() {}
    
    public User(Long id, String username, String email, 
    		String password, String switchfc, String threedsfc) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.switchfc = switchfc;
        this.threedsfc = threedsfc;
        this.pokedexes = new HashSet<Pokedex>();
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSwitchfc() {
        return switchfc;
    }
 
    public void setSwitchfc(String switchfc) {
        this.switchfc = switchfc;
    }
    
    public String getThreedsfc() {
        return threedsfc;
    }
 
    public void setThreedsfc(String threedsfc) {
        this.threedsfc = threedsfc;
    }
    
    public Set<Pokedex> getPokedexes() {
    	return pokedexes;
    }
    
    public void setPokedexes(Set<Pokedex> pokedexes) {
    	this.pokedexes = pokedexes;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
    }
     
 
     
}