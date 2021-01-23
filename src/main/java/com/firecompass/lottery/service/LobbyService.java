package com.firecompass.lottery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.firecompass.lottery.model.Lobby;
import com.firecompass.lottery.model.Player;
import com.firecompass.lottery.repo.LobbyRepo;
import com.firecompass.lottery.util.ProjectUtil;

@Service 
public class LobbyService {

	@Autowired
	LobbyRepo lobbyRepo;	
		
	public boolean addLobby(Integer entryFee,Integer numberOfPlayers) {
		List<Player> playerList = new ArrayList<Player>();
		Lobby lobby = new Lobby();
		lobby.setEntryFee(entryFee);
		lobby.setLimitReached(false);
		lobby.setNumberOfPlayers(numberOfPlayers);
		lobby.setPlayerList(playerList);
		String lobbyId = String.valueOf(ProjectUtil.getRandomvalue(10000));
		return lobbyRepo.addLobby(lobby, lobbyId);
	}
	
	public Map<String, Lobby> getAllLobbies() {
		return lobbyRepo.getLobbyMap();
	}
	
	public Lobby getLobby(String lobbyId) {
		return lobbyRepo.getLobbyMap().get(lobbyId);
	}
	
	public boolean addUser(String playerName, String lobbyId) {
		Player player = new Player();
		player.setPlayerName(playerName);
		addUser(player, lobbyId);
		return true;
	}
	
	private void addUser(Player player, String lobbyId) {
		if(!lobbyRepo.getLobbyMap()
				.get(lobbyId)
					.isLimitReached()) {
			lobbyRepo.addToLobby(player, lobbyId);
		}
	}
	
	public void removeLobby(String lobbyId) {
		lobbyRepo.removeLobby(lobbyId);
	}
}
