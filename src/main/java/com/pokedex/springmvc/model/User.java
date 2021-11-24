package com.pokedex.springmvc.model;

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
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(min=1, max=50)
    @Column(name = "USERNAME", unique=true)
    private String username;
    
    @Size(min=1, max=50)
    @Column(name = "EMAIL", unique=true)
    private String email;

    @Size(min=7, max=50)
    @Column(name = "PASSWORD")
    private String password;
    
    @Size(min=14, max=14)
    @Column(name = "SWITCHFC")
    private String switchfc;
    
    @Size(min=14, max=14)
    @Column(name = "THREEDSFC")
    private String threedsfc;
    
    // @Transaction either on Dao or service layer 
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "PUSER", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Pokedex> pokedexes;
     
    public User() {}
    
    public User(Integer id, String username, String email, 
    		String password, String switchfc, String threedsfc) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.switchfc = switchfc;
        this.threedsfc = threedsfc;
        this.pokedexes = new HashSet<Pokedex>();
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
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
    
    public String getSwitchFC() {
        return switchfc;
    }
 
    public void setSwitchFC(String switchfc) {
        this.switchfc = switchfc;
    }
    
    public String getThreeDSFC() {
        return threedsfc;
    }
 
    public void setThreeDSFC(String threedsfc) {
        this.threedsfc = threedsfc;
    }
    
    public Set<Pokedex> getPokedexes() {
    	return pokedexes;
    }
    
    public void setPokedexes(Set<Pokedex> pokedexes) {
    	this.pokedexes = pokedexes;
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
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
    }
     
 
     
}