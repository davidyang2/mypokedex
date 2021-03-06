package com.pokedex.springmvc.service;

import java.util.List;

import com.pokedex.springmvc.model.User;
 
public interface UserService {
     
    public User findById(Long id);
    
    public User findByEmail(String email);
     
    public User createUser(User user);
     
    public User updateUser(User user);
     
    public int deleteUserByEmail(String email);
    
    public int deleteUserById(Long id);
 
    public List<User> findAllUsers();
    
    public Boolean isUserExist(User user);

}