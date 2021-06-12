package com.football.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.football.ApiConfig;

import junit.framework.Assert;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class UtilTest {
	
	@Injectable
	private ApiConfig apiConfig;
	
	@Tested
	ProjectUtil projectUtil;	
	
	@Test
	public void TestStanding() {
		new Expectations() {
			{
				apiConfig.getApikey(); result = "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
				apiConfig.getBaseurl(); result = "https://apiv2.apifootball.com/";
				apiConfig.getStandingurl(); result="?action=get_standings&league_id=";
			}
		};
		assertEquals(false, projectUtil.getTeamStanding("148").isEmpty());
	}
	
	@Test
	public void TestLeagueDetails() {
		new Expectations() {
			{
				apiConfig.getApikey(); result = "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
				apiConfig.getBaseurl(); result = "https://apiv2.apifootball.com/";
				apiConfig.getLeagueurl(); result="?action=get_leagues&country_id=";
			}
		};
		assertEquals(false, projectUtil.getLeagueDetails("41").isEmpty());
	}
	
	@Test
	public void TestCountryDetails() {
		new Expectations() {
			{
				apiConfig.getApikey(); result = "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
				apiConfig.getBaseurl(); result = "https://apiv2.apifootball.com/";
				apiConfig.getCountryurl(); result="?action=get_countries";
			}
		};
		assertEquals(false, projectUtil.getcountryDetails().isEmpty());
	}
	
	@Test
	public void TestStandingException() {
		new Expectations() {
			{
				apiConfig.getApikey(); result = "dummy";
				apiConfig.getBaseurl(); result = "apiv2.apifootball.com/";
				apiConfig.getStandingurl(); result="?action=get_standings&league_id=";
			}
		};
		assertEquals(true, projectUtil.getTeamStanding("148").isEmpty());
	}
	
	@Test
	public void TestLeagueDetailsException() {
		new Expectations() {
			{
				apiConfig.getApikey(); result = "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
				apiConfig.getBaseurl(); result = "apiv2.apifootball.com/";
				apiConfig.getLeagueurl(); result="?action=get_leagues&country_id=";
			}
		};
		assertEquals(null, projectUtil.getLeagueDetails("41"));
	}
	
	@Test
	public void TestCountryDetailsException() {
		new Expectations() {
			{
				apiConfig.getApikey(); result = "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
				apiConfig.getBaseurl(); result = "apiv2.apifootball.com/";
				apiConfig.getCountryurl(); result="?action=get_countries";
			}
		};
		assertEquals(true, projectUtil.getcountryDetails().isEmpty());
	}
}	
