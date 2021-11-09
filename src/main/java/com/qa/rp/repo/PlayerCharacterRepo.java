package com.qa.rp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rp.domain.PlayerCharacter;


@Repository
public interface PlayerCharacterRepo extends JpaRepository<PlayerCharacter, Integer> {	

}
