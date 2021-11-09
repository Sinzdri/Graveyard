package com.qa.rp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rp.domain.PlayerCharacter;
import com.qa.rp.service.PlayerCharacterService;


@RestController	//enable request handling
@RequestMapping("/pc")	//mapping requests to /pc
public class PlayerCharacterController {
	private PlayerCharacterService service;
	
	@Autowired // Inject dependency from the context
	public PlayerCharacterController(PlayerCharacterService service) {
		this.service = service;
	}
	
//	@GetMapping("/test")	//test mapping for basic string response
//	public String hello() {
//		return "Hello World!"; 
//	}
	
	@PostMapping("/create")	// add new character to db
	public ResponseEntity<PlayerCharacter> createCharacter(@RequestBody PlayerCharacter newPlayerCharacter) {
		PlayerCharacter responseBody = this.service.addCharacter(newPlayerCharacter);
		return new ResponseEntity<PlayerCharacter>(responseBody, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")	// get all characters
	public List<PlayerCharacter> getCharacters(){
		return this.service.getAllCharacters();
	}
	
	@GetMapping("/get/{id}") // get character with id of id
	public PlayerCharacter getCharacter(@PathVariable int id) {
		return this.service.getCharacterByID(id);
	}
	
	@PutMapping("/replace/{id}")
	public ResponseEntity<PlayerCharacter> replaceCharacter(@PathVariable int id, @RequestBody PlayerCharacter newCharacter) {
		System.out.println("Replacing character with id " + id + " with character entry " + newCharacter);
		PlayerCharacter responseBody = this.service.replaceCharacter(id, newCharacter); //replaces the character at index id
		return new ResponseEntity<PlayerCharacter>(responseBody, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeCharacter(@PathVariable int id){
		System.out.println("Removing character with id " + id);
		boolean removed = this.service.deleteCharacter(id);
		if (removed) {
			return new ResponseEntity<>("Removing character with id " + id, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
