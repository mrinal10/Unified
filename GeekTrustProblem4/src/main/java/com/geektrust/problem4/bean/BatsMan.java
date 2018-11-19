package com.geektrust.problem4.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BatsMan {
	private String playerName;
	private int noOfBallsFaced;
	private int runsScored;
	private boolean isOut;
	private boolean batted;
	private Map<Integer, Integer> probabilityMap;
	private List<Integer> listOfOutComes = new ArrayList<Integer>();

	public BatsMan(String playername) {
		playerName = playername;
		isOut = false;
		batted = false;
	}

	private void randomizeList() {
		for (Entry<Integer, Integer> entry : probabilityMap.entrySet()) {
			int value = (int) entry.getValue();
			int i = 0;
			while (i < value) {
				listOfOutComes.add((Integer) entry.getKey());
				i++;
			}
		}
		Collections.shuffle(listOfOutComes);
	}

	public List<Integer> getListOfOutComes() {
		return listOfOutComes;
	}

	public void setListOfOutComes(List<Integer> listOfOutCms) {
		listOfOutComes = listOfOutCms;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playersName) {
		playerName = playersName;
	}

	public int getNoOfBallsFaced() {
		return noOfBallsFaced;
	}

	public void setNoOfBallsFaced(int noOfBallsFaced) {
		this.noOfBallsFaced = noOfBallsFaced;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public Map<Integer, Integer> getProbabilityMap() {
		return probabilityMap;
	}

	public void setProbabilityMap(Map<Integer, Integer> probabilityMap) {
		this.probabilityMap = probabilityMap;
		randomizeList();
	}

	public boolean isOut() {
		return isOut;
	}

	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	public boolean isBatted() {
		return batted;
	}

	public void setBatted(boolean batted) {
		this.batted = batted;
	}

}
