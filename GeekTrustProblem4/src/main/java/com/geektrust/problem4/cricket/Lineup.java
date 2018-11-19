package com.geektrust.problem4.cricket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.geektrust.problem4.bean.BatsMan;
import com.geektrust.problem4.bean.Player;
import com.geektrust.problem4.bean.PlayerListReader;

@Repository
@Scope("prototype")
public class Lineup {
	private List<BatsMan> playerList = new ArrayList<BatsMan>();

	@Autowired
	PlayerListReader listReader;
	
	public void init(String battingTeamName){
		List<Player> playersList = listReader.getPlayerList(battingTeamName);
		for (int i = 0; i < playersList.size(); i++) {
			Player currentPlayer = playersList.get(i);
			BatsMan batsMan = new BatsMan(currentPlayer.getPlayerName());
			batsMan.setProbabilityMap(currentPlayer.getScoringMap());
			playerList.add(batsMan);
		}
	}

	public List<BatsMan> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<BatsMan> playersList) {
		playerList = playersList;
	}
	
	
}
