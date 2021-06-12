package com.football.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.football.ApiConfig;
import com.football.entity.Country;
import com.football.entity.LeagueDetails;
import com.football.entity.Request;
import com.football.entity.TeamStanding;
import com.football.util.ProjectUtil;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class ApiServiceTest {

	@Tested
	TeamStandingServiceImpl targetBeingTested;

	@Injectable
	ObjectMapper mapper;

	@Injectable
	ProjectUtil projectUtil;

	@Injectable
	ApiConfig apiConfig;

	@Injectable
	Request customReq;

	Country country;
	Country[] contryList;
	LeagueDetails[] leagueList;
	TeamStanding[] teamStandList;

	@Before
	public void initiate() {
		customReq = new Request();
		customReq.setCountryName("england");
		customReq.setLeqagueName("test");
		customReq.setTeamName("testTeam");

		country = new Country();
		country.setCountry_id("41");
		country.setCountry_name("England");

		contryList = new Country[1];
		contryList[0] = country;

		LeagueDetails leagueDetails = new LeagueDetails();
		leagueDetails.setLeague_id("100");
		leagueDetails.setLeague_name("test");
		leagueDetails.setCountry_id("41");

		leagueList = new LeagueDetails[1];
		leagueList[0] = leagueDetails;

		TeamStanding teamStanding = new TeamStanding();
		teamStanding.setTeam_name("testTeam");
		teamStanding.setOverall_league_position("6");

		teamStandList = new TeamStanding[1];
		teamStandList[0] = teamStanding;
	}

	@Test
	public void getTeamStandingTest() {
		try {
			new Expectations() {
				{
					mapper.readValue(anyString, Country[].class);
					result = contryList;
					mapper.readValue(anyString, LeagueDetails[].class);
					result = leagueList;
					mapper.readValue(anyString, TeamStanding[].class);
					result = teamStandList;
					projectUtil.getcountryDetails();
					result = "testValue";
					projectUtil.getLeagueDetails(anyString);
					result = "anyString";
					projectUtil.getTeamStanding(anyString);
					result = "anyString";
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(targetBeingTested.getTeamStanding(customReq).getMessage(), toString());
	}
	
	@Test
	public void getTeamStanding1Test() {
		try {
			new Expectations() {
				{
					mapper.readValue(anyString, Country[].class);
					result = contryList;
					mapper.readValue(anyString, LeagueDetails[].class);
					result = leagueList;
					
					projectUtil.getcountryDetails();
					result = "testValue";
					projectUtil.getLeagueDetails(anyString);
					result = "anyString";
					projectUtil.getTeamStanding(anyString);
					result = "anyString";
				}
			};
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(targetBeingTested.getTeamStanding(customReq).getMessage(), toString());
	}
	
	@Test
	public void getTeamStanding2Test() {
		try {
			new Expectations() {
				{
					mapper.readValue(anyString, Country[].class);
					result = contryList;

					projectUtil.getcountryDetails();
					result = "testValue";
					projectUtil.getLeagueDetails(anyString);
					result = "anyString";

				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(targetBeingTested.getTeamStanding(customReq).getMessage(), toString());
	}

	@Test
	public void getTeamStandingExceptionTest() {

		new Expectations() {
			{
				projectUtil.getcountryDetails();
				result = "testValue";
			}
		};

		assertEquals(targetBeingTested.getTeamStanding(customReq).getMessage(), toString());
	}
}
