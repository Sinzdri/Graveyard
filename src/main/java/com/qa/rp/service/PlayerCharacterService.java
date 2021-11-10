package com.qa.rp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.rp.domain.CharacterRace;
import com.qa.rp.domain.PlayerCharacter;
import com.qa.rp.exceptions.CharacterNotFoundException;
import com.qa.rp.repo.PlayerCharacterRepo;



@Service
public class PlayerCharacterService {
	private PlayerCharacterRepo repo;
	public PlayerCharacterService(PlayerCharacterRepo repo) {
		this.repo = repo;
	}
	
	public PlayerCharacter addCharacter(PlayerCharacter pc){
		return this.repo.save(pc);
	}
	
	public List<PlayerCharacter> getAllCharacters() {
		return this.repo.findAll();
	}
	
	public PlayerCharacter getCharacterByID(Integer id) {
		return this.repo.findById(id).orElseThrow(() -> new CharacterNotFoundException());	//throws exception if null entry at id index
	}
	
	public List<PlayerCharacter> getCharacterByName(String name) {
		return this.repo.findPlayerCharacterBycharactername(name);
	}
	
	public List<PlayerCharacter> getCharacterByPlayerName(String name) {
		return this.repo.findPlayerCharacterByplayername(name);
	}
	
	public List<PlayerCharacter> getCharacterByRace(CharacterRace race) {
		return this.repo.findPlayerCharacterBycharacterrace(race);
	}
	
	public PlayerCharacter replaceCharacter(Integer id, PlayerCharacter newCharacter) {
		PlayerCharacter existing = this.getCharacterByID(id);
		existing.setCauseofdeath(newCharacter.getCauseofdeath());
		existing.setCharacterclass(newCharacter.getCharacterclass());
		existing.setCharacterlevel(newCharacter.getCharacterlevel());
		existing.setCharactername(newCharacter.getCharactername());
		existing.setCharacterrace(newCharacter.getCharacterrace());
		existing.setPlayername(newCharacter.getPlayername());
		return this.repo.save(existing);
	}
	
	public boolean deleteCharacter(Integer id) {
		this.repo.findById(id).orElseThrow(() -> new CharacterNotFoundException());		//check id exists before attempting to delete
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	
}
