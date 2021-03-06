package com.cars24.demo.model;

import com.cars24.demo.utilenum.ChessPieceEnum;
import com.cars24.demo.utilenum.MoveEnum;
import com.cars24.demo.utilenum.PieceColour;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class NextMove {
	@JsonIgnore
	private PieceColour chessColour;
	@JsonIgnore
	private Move playerMove;
	
	@JsonIgnore
	private ChessPieceEnum chessEnum;
	@JsonIgnore
	private String gameToken;
	private MoveEnum moveEnum;
	
	public PieceColour getChessColour() {
		return chessColour;
	}
	public Move getPlayerMove() {
		return playerMove;
	}
	public ChessPieceEnum getChessEnum() {
		return chessEnum;
	}
	public void setChessColour(PieceColour chessColour) {
		this.chessColour = chessColour;
	}
	public void setPlayerMove(Move playerMove) {
		this.playerMove = playerMove;
	}
	public void setChessEnum(ChessPieceEnum chessEnum) {
		this.chessEnum = chessEnum;
	}
	public String getGameToken() {
		return gameToken;
	}
	public MoveEnum getMoveEnum() {
		return moveEnum;
	}
	public void setGameToken(String gameToken) {
		this.gameToken = gameToken;
	}
	public void setMoveEnum(MoveEnum moveEnum) {
		this.moveEnum = moveEnum;
	}
}
