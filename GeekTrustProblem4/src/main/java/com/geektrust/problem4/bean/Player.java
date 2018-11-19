package com.geektrust.problem4.bean;

import java.util.HashMap;

public class Player {
	private String playerName;
	private HashMap<Integer, Integer> scoringMap;
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public HashMap<Integer, Integer> getScoringMap() {
		return scoringMap;
	}
	public void setScoringMap(HashMap<Integer, Integer> scoringMap) {
		this.scoringMap = scoringMap;
	}
}
