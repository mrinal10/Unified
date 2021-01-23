package com.firecompass.lottery.model;

import java.util.List;

public class Lobby {
	private boolean isLimitReached;
	private String lobbyId;
	private Integer numberOfPlayers;
	private List<Player> playerList;
	private Integer entryFee;

	public Integer getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public Integer getEntryFee() {
		return entryFee;
	}

	public void setNumberOfPlayers(Integer numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public void setEntryFee(Integer entryFee) {
		this.entryFee = entryFee;
	}

	public String getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(String lobbyId) {
		this.lobbyId = lobbyId;
	}

	public boolean isLimitReached() {
		return isLimitReached;
	}

	public void setLimitReached(boolean isLimitReached) {
		this.isLimitReached = isLimitReached;
	}
}
