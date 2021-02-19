package com.mindree.Team.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindree.Team.Entity.Player;
import com.mindree.Team.Entity.Team;
import com.mindree.Team.Exception.IdNotFoundException;
import com.mindree.Team.Repository.PlayerRepo;
import com.mindree.Team.Repository.TeamRepo;

@Service	
public class GameService
{

	@Autowired
	private TeamRepo tr;
	
	@Autowired
	private PlayerRepo pr;

	public Team createTeam(Team team) 
	{
		// TODO Auto-generated method stub
		return tr.save(team);
		
	}

	public Player createMind(Player player, int tid) 
	{
		// TODO Auto-generated method stub
		
		
		
		int id;
		
		List<Team> allteams=tr.findAll();		//existing
		List<Player> newplayer=new ArrayList<Player>();
		
		for(Team t:allteams)
		{
		
			id=t.getTid();
			if(id==tid)
			{
				newplayer.add(player);
				
				
			}	
		}	
		return pr.save(player);
		
	}

	public List<Player> getAllDetails(String tname) throws IdNotFoundException {
		// TODO Auto-generated method stub
		int flag=0;
		String teamname="";
		List<Player> player =new ArrayList<Player>();
		List<Player> allplayersadded=pr.findAll();		//existing
		for(Player p:allplayersadded)
		{
			
			teamname=p.getTname();
			if(teamname.equals(tname))
			{
				player.add(p);
				flag=1;
			
			}
		}	
		if(flag!=1)
			throw new IdNotFoundException("Trackname not found!");
		
		return player;
	}

	public Team updateTeamLoc(String location, int tid) throws IdNotFoundException 
	{
		// TODO Auto-generated method stub
		int flag=0;
		List<Team> allteamsadded=tr.findAll();
		
		
		for(Team t:allteamsadded)
		{
			if(t.getTid()==tid)
			{
				
				t.setLocation(location);
				tr.save(t);
				flag=1;
				return t;
			}
		}
		
		
		
		if(flag!=1)
			throw new IdNotFoundException("TeamID not found!");
		
		
		return null;
	}

	public Player deletePlayerByPlayerID(int pid) 
	{
		// TODO Auto-generated method stub
		 Player p=this.pr.findById(pid);
		 pr.delete(p);
				
		return p;
		
	}
	
	
}
