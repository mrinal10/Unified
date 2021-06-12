package com.firecompass.lottery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firecompass.lottery.model.GameResult;
import com.firecompass.lottery.model.Lobby;
import com.firecompass.lottery.model.Player;
import com.firecompass.lottery.util.ProjectUtil;

@Service
public class LotteryService {
	@Autowired
	LobbyService lobbyService;

	public GameResult startGame(String lobbyId) {
		GameResult gameResult = new GameResult();
		gameResult.setStatus(ProjectUtil.NOT_COMPLETED);
		Optional<Lobby> targetLobby = Optional.ofNullable(lobbyService.getLobby(lobbyId));
		if(!targetLobby.isPresent()) {
			return gameResult;
		}
		Lobby lobby = targetLobby.get();
		int lobbySize = lobby.getNumberOfPlayers();
		int winningIndex = ProjectUtil.getRandomvalue(lobbySize);
		Player winningPlayer = lobby.getPlayerList().get(winningIndex);
		double totalWinnings = lobby.getEntryFee()*lobby.getNumberOfPlayers();
		double houseEarning = (totalWinnings*5)/100;
		double playerWins = totalWinnings - houseEarning;
		
		gameResult.setWinningPlayerName(winningPlayer.getPlayerName());
		gameResult.setWinningAmount(playerWins);
		gameResult.setHouseEarning(houseEarning);
		gameResult.setStatus(ProjectUtil.COMPLETED);
		lobbyService.removeLobby(lobbyId);
		return gameResult;
	}
	
	
}