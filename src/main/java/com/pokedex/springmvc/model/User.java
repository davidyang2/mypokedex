package com.pokedex.springmvc.model;

public class User {
	 
    private long id;
     
    private String username;
     
    private String email;
    
    private String password;
    
    private String switchfc;
    
    private String threedsfc;
     
    public User(){
        id=0;
    }
     
    public User(long id, String username, String email, 
    		String password, String switchfc, String threedsfc){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.switchfc = switchfc;
        this.threedsfc = threedsfc;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
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
 
    public void setThreeDSDC(String threedsfc) {
        this.threedsfc = threedsfc;
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