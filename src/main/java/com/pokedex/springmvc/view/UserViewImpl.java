package com.pokedex.springmvc.view;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserViewImpl implements UserView {
	
	@JsonProperty("id")
    private Long id;
    
	@JsonProperty("username")
    private String username;
    
	@JsonProperty("email")
    private String email;

	@JsonProperty("password")
    private String password;
    
	@JsonProperty("switchfc")
    private String switchfc;
    
	@JsonProperty("threedsfc")
    private String threedsfc;
    
	@JsonProperty("pokedexes")
    private Set<PokedexViewImpl> pokedexes;
     
    public UserViewImpl() {}
    
    public UserViewImpl(Long id, String username, String email, 
    		String password, String switchfc, String threedsfc) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.switchfc = switchfc;
        this.threedsfc = threedsfc;
        this.pokedexes = new HashSet<PokedexViewImpl>();
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
    
    public Set<PokedexViewImpl> getPokedexes() {
    	return pokedexes;
    }
    
    public void setPokedexes(Set<PokedexViewImpl> pokedexes) {
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
        if (!(obj instanceof UserViewImpl))
            return false;
        UserViewImpl other = (UserViewImpl) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password= " + password + ", email=" + email + ", switchfc=" + switchfc + ", threedsfc= " + threedsfc;
    }
}
