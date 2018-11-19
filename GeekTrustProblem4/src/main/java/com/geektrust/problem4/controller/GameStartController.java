package com.geektrust.problem4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geektrust.problem4.cricket.GamePlay;

@RestController
@Scope("request")
@ComponentScan("com.geektrust.problem4")
public class GameStartController {
	@Autowired
	GamePlay gamePlay;

	@RequestMapping(value = "/startGame", method = RequestMethod.GET, produces = {"application/json"})
	public String showView() {
		return gamePlay.playGame();
	}
}
