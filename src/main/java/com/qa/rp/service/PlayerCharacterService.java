package com.qa.rp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.rp.domain.CharacterRace;
import com.qa.rp.domain.PlayerCharacter;
import com.qa.rp.dto.PlayerCharacterDTO;
import com.qa.rp.exceptions.CharacterNotFoundException;
import com.qa.rp.repo.PlayerCharacterRepo;



@Service
public class PlayerCharacterService {
	private PlayerCharacterRepo repo;
	
	private ModelMapper mapper;
	
	public PlayerCharacterService(PlayerCharacterRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public PlayerCharacterDTO addCharacter(PlayerCharacterDTO pc){
		PlayerCharacter toadd = this.mapFromDTO(pc);
		PlayerCharacter added = this.repo.save(toadd);
		return this.mapToDTO(added);
	}
	
	public List<PlayerCharacterDTO> getAllCharacters() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public PlayerCharacterDTO getCharacterByID(Integer id) {
		PlayerCharacter returned = this.repo.findById(id).orElseThrow(() -> new CharacterNotFoundException());	//throws exception if null entry at id index
		return this.mapToDTO(returned);
	}
	
	public List<PlayerCharacterDTO> getCharacterByName(String name) {
		return this.repo.findPlayerCharacterBycharactername(name).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<PlayerCharacterDTO> getCharacterByPlayerName(String name) {
		return this.repo.findPlayerCharacterByplayername(name).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<PlayerCharacterDTO> getCharacterByRace(CharacterRace race) {
		return this.repo.findPlayerCharacterBycharacterrace(race).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public PlayerCharacterDTO replaceCharacter(Integer id, PlayerCharacter newCharacter) {
		PlayerCharacter existing = this.repo.findById(id).orElseThrow(() -> new CharacterNotFoundException());
		existing.setCauseofdeath(newCharacter.getCauseofdeath());
		existing.setCharacterclass(newCharacter.getCharacterclass());
		existing.setCharacterlevel(newCharacter.getCharacterlevel());
		existing.setCharactername(newCharacter.getCharactername());
		existing.setCharacterrace(newCharacter.getCharacterrace());
		existing.setPlayername(newCharacter.getPlayername());
		PlayerCharacter replaced = this.repo.save(existing);
		return this.mapToDTO(replaced);
	}
	
	public boolean deleteCharacter(Integer id) {
		this.repo.findById(id).orElseThrow(() -> new CharacterNotFoundException());		//check id exists before attempting to delete
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
    private PlayerCharacterDTO mapToDTO(PlayerCharacter playercharacter) {	//use mapper to convert to DTO
        return this.mapper.map(playercharacter, PlayerCharacterDTO.class);
    }
    
    private PlayerCharacter mapFromDTO(PlayerCharacterDTO playercharacter) {	//use mapper to convert from DTO
        return this.mapper.map(playercharacter, PlayerCharacter.class);
    }
	
	
}
