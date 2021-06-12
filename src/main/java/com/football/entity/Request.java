package com.football.entity;

public class Request {

	private String countryName;
	private String leagueName;
	private String teamName;
	
	@Override
	public String toString() {
		return "Request [countryName=" + countryName + ", leqagueName=" + leagueName + ", teamName=" + teamName + "]";
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeqagueName(String leqagueName) {
		this.leagueName = leqagueName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
