package com.cars24.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cars24.demo.model.Move;
import com.cars24.demo.model.NextMove;
import com.cars24.demo.model.ResponseData;
import com.cars24.demo.service.GameService;
import com.cars24.demo.utilenum.ChessPieceEnum;
import com.cars24.demo.utilenum.MoveEnum;
import com.cars24.demo.utilenum.PieceColour;

@RestController
public class ChessController {
	
	@Autowired
	GameService gameService;
	
	@PostMapping("chessGame/startGame")
    public ResponseData startNewGame(@RequestBody NextMove nextMove) {	
		if(!nextMove.getMoveEnum().equals(MoveEnum.STARTGAME))
			return null;

		return gameService.startGame();
    }
	
	@PostMapping("chessGame/move")
    public List<ResponseData> getDetails(@RequestBody NextMove nextMove) {		
		return null;
    }
	
	@GetMapping("/")
    public NextMove getDummy() {		
		NextMove nextMove = new NextMove();
		nextMove.setChessColour(PieceColour.BLACK);
		nextMove.setChessEnum(ChessPieceEnum.King);
		nextMove.setGameToken("testToken");
		nextMove.setMoveEnum(MoveEnum.MOVE);
		Move mov = new Move();
		mov.setFromLocation("A1");
		mov.setToLocation("A1");
		nextMove.setPlayerMove(mov);
		return nextMove;
    }

}
