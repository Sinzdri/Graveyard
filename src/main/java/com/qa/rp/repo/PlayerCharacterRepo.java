package com.qa.rp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rp.domain.CharacterRace;
import com.qa.rp.domain.PlayerCharacter;


@Repository
public interface PlayerCharacterRepo extends JpaRepository<PlayerCharacter, Integer> {	
	List<PlayerCharacter> findPlayerCharacterBycharactername(String name);
//	List<PlayerCharacter> findPlayerCharacterByplayername(String name);
	List<PlayerCharacter> findPlayerCharacterBycharacterrace(CharacterRace race);
}
