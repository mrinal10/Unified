package com.football;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "get")
public class ApiConfig {
	private String baseurl;
	private String countryurl;
	private String leagueurl;
	private String teamsurl;
	private String standingurl;
	private String apikey;
	
	public String getBaseurl() {
		return baseurl;
	}
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}
	public String getCountryurl() {
		return countryurl;
	}
	public void setCountryurl(String countryurl) {
		this.countryurl = countryurl;
	}
	public String getLeagueurl() {
		return leagueurl;
	}
	public void setLeagueurl(String leagueurl) {
		this.leagueurl = leagueurl;
	}
	public String getTeamsurl() {
		return teamsurl;
	}
	public void setTeamsurl(String teamsurl) {
		this.teamsurl = teamsurl;
	}
	public String getStandingurl() {
		return standingurl;
	}
	public void setStandingurl(String standingurl) {
		this.standingurl = standingurl;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
}
