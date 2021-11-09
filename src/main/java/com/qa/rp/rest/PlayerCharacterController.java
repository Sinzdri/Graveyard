package com.qa.rp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rp.service.PlayerCharacterService;

@RestController	//enable request handling
@RequestMapping("/pc")
public class PlayerCharacterController {
	private PlayerCharacterService service;
	
	@Autowired // Inject dependency from the context
	public PlayerCharacterController(PlayerCharacterService service) {
		this.service = service;
	}
	
	@GetMapping("/test")	//test mapping for basic string response
	public String hello() {
		return "Hello World!"; 
	}
}
