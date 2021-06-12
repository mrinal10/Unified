package com.firecompass.lottery.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firecompass.lottery.model.Lobby;
import com.firecompass.lottery.service.LobbyService;

@RestController
public class AdminController {
	
	@Autowired
	LobbyService lobbyService;
	
	@RequestMapping("admin/addlobby/{playerNumbers}/{entryFee}")
    public boolean addLobby(@PathVariable("playerNumbers") Integer playerNumbers,
    		@PathVariable("entryFee") Integer entryFee) {		
		return lobbyService.addLobby(entryFee, playerNumbers);
    }
	
	@RequestMapping("admin/getAllLobbies")
    public  Map<String, Lobby> getDetails() {	
		return lobbyService.getAllLobbies();
    }

}
