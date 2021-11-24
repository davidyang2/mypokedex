package com.pokedex.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pokedex.springmvc.model.Pokedex;
import com.pokedex.springmvc.model.User;
import com.pokedex.springmvc.service.PokedexService;
import com.pokedex.springmvc.service.UserService;

@RestController
public class PokedexController {

    @Autowired
    PokedexService pokedexService;  //Service which will do all data retrieval/manipulation work
    
    //-------------------Retrieve All Pokedexes--------------------------------------------------------
    
    @RequestMapping(value = "/pokedex/", method = RequestMethod.GET)
    public ResponseEntity<List<Pokedex>> listAllPokedexes() {
        List<Pokedex> pokedexes = pokedexService.findAllPokedexes();
        if(pokedexes.isEmpty()){
            return new ResponseEntity<List<Pokedex>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Pokedex>>(pokedexes, HttpStatus.OK);
    }
    
    //-------------------Retrieve All Pokedexes By Username--------------------------------------------
    @RequestMapping(value = "/pokedex/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Pokedex>> listAllPokedexesByUsername(@PathVariable("username") String username) {
    	 List<Pokedex> pokedexes = pokedexService.findAllPokedexesByUsername(username);
         if(pokedexes.isEmpty()){
             return new ResponseEntity<List<Pokedex>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
         }
         return new ResponseEntity<List<Pokedex>>(pokedexes, HttpStatus.OK);
    }
  
     
    //-------------------Retrieve Single Pokedex--------------------------------------------------------
      
    @RequestMapping(value = "/pokedex/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pokedex> getPokedex(@PathVariable("id") Integer id) {
        System.out.println("Fetching User with id " + id);
        Pokedex pokedex = pokedexService.findById(id);
        if (pokedex == null) {
            System.out.println("Pokedex with id " + id + " not found");
            return new ResponseEntity<Pokedex>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pokedex>(pokedex, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Pokedex--------------------------------------------------------
      
    @RequestMapping(value = "/pokedex/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Pokedex pokedex, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Pokedex " + pokedex.getName());
  
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
  
        pokedexService.createPokedex(pokedex);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/pokedex/{id}").buildAndExpand(pokedex.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Pokedex --------------------------------------------------------
      
    @RequestMapping(value = "/pokedex/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pokedex> updatePokedex(@PathVariable("id") Integer id, @RequestBody Pokedex pokedex) {
        System.out.println("Updating Pokedex " + id);
          
        Pokedex currentPokedex = pokedexService.findById(id);
          
        if (currentPokedex==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Pokedex>(HttpStatus.NOT_FOUND);
        }
  
        currentPokedex.setName(pokedex.getName());
        currentPokedex.setGame(pokedex.getGame());
        currentPokedex.setRegionality(pokedex.getRegionality());
        currentPokedex.setShiny(pokedex.getShiny());
          
        pokedexService.updatePokedex(currentPokedex);
        return new ResponseEntity<Pokedex>(currentPokedex, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Pokedex --------------------------------------------------------
      
    @RequestMapping(value = "/pokedex/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pokedex> deletePokedex(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        Pokedex pokedex = pokedexService.findById(id);
        if (pokedex == null) {
            System.out.println("Unable to delete. Pokedex with id " + id + " not found");
            return new ResponseEntity<Pokedex>(HttpStatus.NOT_FOUND);
        }
  
        pokedexService.deletePokedexById(id);
        return new ResponseEntity<Pokedex>(HttpStatus.NO_CONTENT);
        }
}
