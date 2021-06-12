package com.firecompass.lottery.model;

public class GameResult {
	private String winningPlayerName;
	private Double winningAmount;
	private Double houseEarning;
	private String status;
	
	public String getWinningPlayerName() {
		return winningPlayerName;
	}

	public Double getWinningAmount() {
		return winningAmount;
	}

	public Double getHouseEarning() {
		return houseEarning;
	}

	public void setWinningPlayerName(String winningPlayerName) {
		this.winningPlayerName = winningPlayerName;
	}

	public void setWinningAmount(Double winningAmount) {
		this.winningAmount = winningAmount;
	}

	public void setHouseEarning(Double houseEarning) {
		this.houseEarning = houseEarning;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
