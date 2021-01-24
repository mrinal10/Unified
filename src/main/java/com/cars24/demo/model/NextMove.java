package com.cars24.demo.model;

public class NextMove {
	private String chessColour;
	private Move playerMove;
	private Enum chessEnum;
	private String gameToken;
	private Enum moveEnum;
	
	public String getChessColour() {
		return chessColour;
	}
	public Move getPlayerMove() {
		return playerMove;
	}
	public Enum getChessEnum() {
		return chessEnum;
	}
	public void setChessColour(String chessColour) {
		this.chessColour = chessColour;
	}
	public void setPlayerMove(Move playerMove) {
		this.playerMove = playerMove;
	}
	public void setChessEnum(Enum chessEnum) {
		this.chessEnum = chessEnum;
	}
	public String getGameToken() {
		return gameToken;
	}
	public Enum getMoveEnum() {
		return moveEnum;
	}
	public void setGameToken(String gameToken) {
		this.gameToken = gameToken;
	}
	public void setMoveEnum(Enum moveEnum) {
		this.moveEnum = moveEnum;
	}
}
