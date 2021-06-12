package com.firecompass.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firecompass.lottery.model.GameResult;
import com.firecompass.lottery.service.LotteryService;

@RestController
public class GameController {
	
	@Autowired
	LotteryService lotteryService;
	
	@RequestMapping("lottery/startGame/{lobbyId}")
    public GameResult getDetails(@PathVariable("lobbyId") String lobbyId) {		
		return lotteryService.startGame(lobbyId);
    }

}
