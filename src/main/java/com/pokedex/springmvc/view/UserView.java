package com.pokedex.springmvc.view;

public interface UserView {
	public Integer getId();
 
    public void setId(Integer id);
 
    public String getUsername();
 
    public void setUsername(String username);
 
    public String getEmail();
 
    public void setEmail(String email);
    
    public String getPassword();
 
    public void setPassword(String password);
    
    public String getSwitchFC();
 
    public void setSwitchFC(String switchfc);
    
    public String getThreeDSFC();
 
    public void setThreeDSFC(String threedsfc);
}
