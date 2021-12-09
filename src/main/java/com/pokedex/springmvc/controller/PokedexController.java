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
import com.pokedex.springmvc.view.PokedexViewImpl;
import com.pokedex.springmvc.manager.PokedexManager;

@RestController
public class PokedexController {
	
    @Autowired
    PokedexManager pokedexManager;  //Service which will do all data retrieval/manipulation work
    
    //-------------------Retrieve All Pokedexes--------------------------------------------------------
    
    @RequestMapping(value = "/pokedex", method = RequestMethod.GET)
    public ResponseEntity<List<PokedexViewImpl>> listAllPokedexes() {
        List<PokedexViewImpl> pokedexes = pokedexManager.getAllPokedexes();
        if(pokedexes.isEmpty()){
            return new ResponseEntity<List<PokedexViewImpl>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PokedexViewImpl>>(pokedexes, HttpStatus.OK);
    }
    
    //-------------------Retrieve All Pokedexes By Username--------------------------------------------
    @RequestMapping(value = "/pokedex/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<PokedexViewImpl>> listAllPokedexesByUsername(@PathVariable("username") String username) {
    	 List<PokedexViewImpl> pokedexes = pokedexManager.getAllPokedexesByUsername(username);
         if(pokedexes.isEmpty()){
             return new ResponseEntity<List<PokedexViewImpl>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
         }
         return new ResponseEntity<List<PokedexViewImpl>>(pokedexes, HttpStatus.OK);
    }
  
     
    //-------------------Retrieve Single Pokedex--------------------------------------------------------
      
    @RequestMapping(value = "/pokedex/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PokedexViewImpl> getPokedex(@PathVariable("id") Long id) {
        System.out.println("Fetching User with id " + id);
        PokedexViewImpl pokedex = pokedexManager.findPokedexById(id);
        if (pokedex == null) {
            System.out.println("Pokedex with id " + id + " not found");
            return new ResponseEntity<PokedexViewImpl>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PokedexViewImpl>(pokedex, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Pokedex--------------------------------------------------------
      
    @RequestMapping(value = "/pokedex", method = RequestMethod.POST)
    public ResponseEntity<PokedexViewImpl> createUser(@RequestBody PokedexViewImpl pokedex) {
        System.out.println("Creating Pokedex " + pokedex.getName());
  
        PokedexViewImpl pokedexView = pokedexManager.createPokedex(pokedex);
        
        System.out.println(pokedex);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/pokedex/{id}").buildAndExpand(pokedex.getId()).toUri());
        return new ResponseEntity<PokedexViewImpl>(pokedexView, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Pokedex --------------------------------------------------------
      
    @RequestMapping(value = "/pokedex/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PokedexViewImpl> updatePokedex(@PathVariable("id") Long id, @RequestBody Pokedex pokedex) {
        System.out.println("Updating Pokedex " + id);
          
        PokedexViewImpl currentPokedex = pokedexManager.findPokedexById(id);
          
        if (currentPokedex==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<PokedexViewImpl>(HttpStatus.NOT_FOUND);
        }
  
        currentPokedex.setName(pokedex.getName());
        currentPokedex.setGame(pokedex.getGame());
        currentPokedex.setRegionality(pokedex.getRegionality());
        currentPokedex.setShiny(pokedex.getShiny());
          
        pokedexManager.updatePokedex(currentPokedex);
        return new ResponseEntity<PokedexViewImpl>(currentPokedex, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Pokedex --------------------------------------------------------
      
    @RequestMapping(value = "/pokedex/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePokedex(@PathVariable("id") Long id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        PokedexViewImpl pokedex = pokedexManager.findPokedexById(id);
        if (pokedex == null) {
            System.out.println("Unable to delete. Pokedex with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  
        pokedexManager.deletePokedexById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
