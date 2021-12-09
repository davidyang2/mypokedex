package com.pokedex.springmvc.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pokedex.springmvc.manager.UserManager;
import com.pokedex.springmvc.model.User;
import com.pokedex.springmvc.service.UserService;
import com.pokedex.springmvc.view.UserViewImpl;
  
@Controller
public class UserController {
  
    @Autowired
    UserManager userManager;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Users--------------------------------------------------------
      
    @RequestMapping(value = {"/user/"}, method = RequestMethod.GET)
    public String listAllUsers(ModelMap model) {
        List<UserViewImpl> users = userManager.getAllUsers();
        model.addAttribute("users", users);
        return "AllUsers";
    }
    
//    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
//    public ResponseEntity<List<UserViewImpl>> listAllUsers() {
//        List<UserViewImpl> users = userManager.getAllUsers();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<UserViewImpl>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<UserViewImpl>>(users, HttpStatus.OK);
//    }
  
  
     
    //-------------------Retrieve Single User--------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        System.out.println("Fetching User with id " + id);
        UserViewImpl user = userManager.findUserById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a User--------------------------------------------------------
      
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserViewImpl> createUser(@RequestBody UserViewImpl user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
  
        if (userManager.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<UserViewImpl>(HttpStatus.CONFLICT);
        }
  
        UserViewImpl userView = userManager.createUser(user);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<UserViewImpl>(headers, HttpStatus.CREATED);
    }
    
    
  
     
      
    //------------------- Update a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserViewImpl> updateUser(@PathVariable("id") Long id, @RequestBody UserViewImpl user) {
        System.out.println("Updating User " + id);
        System.out.println(user);  
        UserViewImpl currentUser = userManager.findUserById(id);
          
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<UserViewImpl>(HttpStatus.NOT_FOUND);
        }
  
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        currentUser.setSwitchfc(user.getSwitchfc());
        currentUser.setThreedsfc(user.getThreedsfc());
          
        userManager.updateUser(currentUser);
        return new ResponseEntity<UserViewImpl>(currentUser, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        UserViewImpl user = userManager.findUserById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  
        userManager.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  
      
 
}
