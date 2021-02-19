package com.mindree.Team.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindree.Team.Entity.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer>
{
	public Player findById(int pid);
}
