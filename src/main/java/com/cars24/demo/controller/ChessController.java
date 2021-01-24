package com.cars24.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cars24.demo.model.NextMove;
import com.cars24.demo.model.ResponseData;
import com.cars24.demo.service.FundService;
import com.cars24.demo.utilenum.MoveEnum;

@RestController
public class ChessController {
	
	@Autowired
	FundService fundService;
	
	@PostMapping("chessGame/startGame")
    public List<ResponseData>startNewGame(@RequestBody NextMove nextMove) {	
		if(!nextMove.getMoveEnum().equals(MoveEnum.STARTGAME))
			return null;
		//TODO call appropriate service to configure a new Game 
		// and return Randomized gameToken as identifier
		return null;
    }
	
	@PostMapping("chessGame/move")
    public List<ResponseData> getDetails(@RequestBody NextMove nextMove) {		
		return null;
    }

}
