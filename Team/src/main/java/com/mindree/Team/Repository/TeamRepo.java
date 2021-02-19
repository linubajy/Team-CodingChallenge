package com.mindree.Team.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindree.Team.Entity.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer> 
{
	
}
