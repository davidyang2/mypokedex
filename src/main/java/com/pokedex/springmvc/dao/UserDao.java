package com.pokedex.springmvc.dao;

import java.util.List;

import com.pokedex.springmvc.model.User;

public interface UserDao {
	
    public User findById(Long id);
    
    public User findByEmail(String email);
    
    public User createUser(User user);
    
    public int deleteUserById(Long id);
     
    public int deleteUserByEmail(String email);
     
    public List<User> findAllUsers();
 
    public User findUserByEmail(String email);

    public User findUserByUsername(String username);
    
    public Boolean isUserExist(User user);
    
    public User updateUser(User user);
}
