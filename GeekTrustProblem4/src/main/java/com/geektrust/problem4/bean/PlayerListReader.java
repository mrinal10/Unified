package com.geektrust.problem4.bean;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("data")
public class PlayerListReader {
	
	private String description;
	private List<Player> lengaBuru;
	private List<Player> drawLengaBuru;
	private List<Player> enchaidraw;
	private List<Player> playerList;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Player> getPlayerList(String battingTeamName) {
		if (battingTeamName.equals("")) {
			return playerList;
		}else if(battingTeamName.startsWith("drawEncha")){
			return enchaidraw;
		}else if(battingTeamName.equalsIgnoreCase("drawLengaBuru")){
			return drawLengaBuru;
		}
		return lengaBuru;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	@Override
	public String toString() {
		return "PlayerListReader [description=" + description
				+ ", PlayerList=" + playerList + "]";
	}
	public List<Player> getLengaBuru() {
		return lengaBuru;
	}
	public void setLengaBuru(List<Player> lengaBuru) {
		this.lengaBuru = lengaBuru;
	}
	
	public List<Player> getEnchaidraw() {
		return enchaidraw;
	}
	public void setEnchaidraw(List<Player> enchaidraw) {
		this.enchaidraw = enchaidraw;
	}
	public List<Player> getDrawLengaBuru() {
		return drawLengaBuru;
	}
	public void setDrawLengaBuru(List<Player> drawLengaBuru) {
		this.drawLengaBuru = drawLengaBuru;
	}
}
