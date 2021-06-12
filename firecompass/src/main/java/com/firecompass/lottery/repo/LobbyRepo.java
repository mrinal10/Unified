package com.firecompass.lottery.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.firecompass.lottery.model.Lobby;
import com.firecompass.lottery.model.Player;

@Component
public class LobbyRepo {
	private Map<String, Lobby> lobbyMap;

	public LobbyRepo() {
		lobbyMap = new HashMap<String, Lobby>();
	}

	public Map<String, Lobby> getLobbyList() {
		return lobbyMap;
	}
	public boolean addLobby(Lobby lobby, String lobbyId) {
		if(lobbyMap==null) {
			lobbyMap = new HashMap<String, Lobby>();
		}
		lobby.setLobbyId(lobbyId);
		lobbyMap.put(lobbyId, lobby);
		return true;
	}
	public boolean addToLobby(Player player, String lobbyId) {
		if(!lobbyMap.containsKey(lobbyId)) {
			return false;
		}
		Lobby lobby = lobbyMap.get(lobbyId);
		List<Player> playerList = lobby.getPlayerList();
		if(playerList.size()<lobby.getNumberOfPlayers()) {
			playerList.add(player);
		}
		if(playerList.size()==lobby.getNumberOfPlayers()) {
			lobby.setLimitReached(true);
		}
		return true;
	}
	
	public boolean removeLobby(String lobbyId) {
		if (!lobbyMap.containsKey(lobbyId)) {
			return false;
		}
		lobbyMap.remove(lobbyId);
		return true;
	}

	public Map<String, Lobby> getLobbyMap() {
		return lobbyMap;
	}

}
