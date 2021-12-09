package com.pokedex.springmvc.view;

public interface UserView {
	public Long getId();
 
    public void setId(Long id);
 
    public String getUsername();
 
    public void setUsername(String username);
 
    public String getEmail();
 
    public void setEmail(String email);
    
    public String getPassword();
 
    public void setPassword(String password);
    
    public String getSwitchfc();
 
    public void setSwitchfc(String switchfc);
    
    public String getThreedsfc();
 
    public void setThreedsfc(String threedsfc);
}
