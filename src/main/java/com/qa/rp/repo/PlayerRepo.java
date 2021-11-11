package com.qa.rp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.qa.rp.domain.Player;


@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {	
}
