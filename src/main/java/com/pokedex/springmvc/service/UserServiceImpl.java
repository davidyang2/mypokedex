package com.pokedex.springmvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
import org.springframework.stereotype.Service;
 
import com.pokedex.springmvc.dao.UserDao;
import com.pokedex.springmvc.model.User;

@Service("userService")
@Transactional // Move to methods
public class UserServiceImpl implements UserService{
	
    @Autowired
    private UserDao dao; // change to userDao
     
    public User findById(Long id) {
        return dao.findById(id);
    }
    
    public User findByEmail(String email) {
        return dao.findByEmail(email);
    }
 
    public User createUser(User user) {
        return dao.createUser(user);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public User updateUser(User user) {
//        User entity = dao.findById(user.getId());
//        if(entity!=null){
//            entity.setUsername(user.getUsername());
//            entity.setEmail(user.getEmail());
//            entity.setPassword(user.getPassword());
//            entity.setSwitchFC(user.getSwitchFC());
//            entity.setThreeDSFC(user.getThreeDSFC());
//            entity.setPokedexes(user.getPokedexes());
//        }
//        return entity;
    	return dao.updateUser(user);
    }
 
    public int deleteUserByEmail(String email) {
        return dao.deleteUserByEmail(email);
    }
    
    public int deleteUserById(Long id) {
    	return dao.deleteUserById(id);
    }
    
     
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
 
    public User findUserByUsername(String username) {
        return dao.findUserByUsername(username);
    }

	public Boolean isUserExist(User user) {
		return dao.isUserExist(user);
	}

 
}