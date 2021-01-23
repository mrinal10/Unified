package com.firecompass.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firecompass.lottery.service.LobbyService;

@RestController
public class UserController {
	
	@Autowired
	LobbyService lobbyService;
	
	@RequestMapping("lottery/addplayer/{playerName}/{lobbyId}")
    public boolean getDetails(@PathVariable("playerName") String playerName,
    		@PathVariable("lobbyId") String lobbyId) {		
		return lobbyService.addUser(playerName, lobbyId);
    }

}
