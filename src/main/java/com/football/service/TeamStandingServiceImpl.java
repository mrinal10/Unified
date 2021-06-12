package com.football.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.football.entity.Country;
import com.football.entity.LeagueDetails;
import com.football.entity.Request;
import com.football.entity.Response;
import com.football.entity.TeamStanding;
import com.football.util.ProjectUtil;

@Service
public class TeamStandingServiceImpl implements TeamStandingService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TeamStandingServiceImpl.class);

	@Autowired
	ProjectUtil projectUtil;

	@Autowired
	ObjectMapper mapper;
	
	@Override
	public Response getTeamStanding(Request teamRequest) {
		Response response = new Response();
		Optional<Country> countryOptional = getCountryDetails(teamRequest.getCountryName());
		Country country;
		if(countryOptional.isPresent()) {
			country = countryOptional.get();
			response.setCountryId(country.getCountry_id());
			response.setCountryName(country.getCountry_name());
		} else {
			response.setMessage("Country Data Not Found");
			return response;
		}
		
		Optional<LeagueDetails> leagueDetailsOptional = getLeagueDetails(country.getCountry_id(), teamRequest.getLeagueName());
		LeagueDetails league;
		if(leagueDetailsOptional.isPresent()) {
			league = leagueDetailsOptional.get();
			response.setLeagueId(league.getLeague_id());
			response.setLeagueName(league.getLeague_name());
		}
		else {
			response.setMessage("league Data Not Found");
			return response;
		}
		
		Optional<TeamStanding> teamRankOptional = getTeamsRank(league.getLeague_id(), teamRequest.getTeamName());
		String teamRank;
		if(teamRankOptional.isPresent()) {
			teamRank = teamRankOptional.get().getOverall_league_position();
			response.setTeamName(teamRankOptional.get().getTeam_name());
			response.setTeamId(teamRankOptional.get().getTeam_id());
			response.setMessage("TeamsRank :: "+teamRank);
		} else {
			response.setMessage("Team Data Not Found");
		}		
		return response;
	}
	
	private Optional<LeagueDetails> getLeagueDetails(String countryId, String leagueName) {
		String leagueData = projectUtil.getLeagueDetails(countryId);
		List<LeagueDetails> listS = null;
		LOGGER.debug("logg :: {}" , leagueData);
		try {
			listS = Arrays.asList(mapper.readValue(leagueData, LeagueDetails[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (LeagueDetails league : listS) {
			if(league.getCountry_id().equals(countryId)  &&  league.getLeague_name().equalsIgnoreCase(leagueName)) {
				return Optional.ofNullable(league);
			}
		}
		return Optional.ofNullable(null);
	}
	
	private Optional<Country> getCountryDetails(String countryName) {
		String countries = projectUtil.getcountryDetails();
		List<Country> listS = null;
		LOGGER.debug("logg :: {}" , countries);
		try {
			listS = Arrays.asList(mapper.readValue(countries, Country[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Country country : listS) {
			if(country.getCountry_name().equalsIgnoreCase(countryName)) {
				return Optional.ofNullable(country);
			}
		}
		return Optional.ofNullable(null);
	}

	private Optional<TeamStanding> getTeamsRank(String leagueId, String teamName) {
		String teamStand = projectUtil.getTeamStanding(leagueId);
		List<TeamStanding> listS = null;
		LOGGER.debug("logg :: {}" , teamStand);
		try {
			listS = Arrays.asList(mapper.readValue(teamStand, TeamStanding[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (TeamStanding teamStanding : listS) {
			if (teamStanding.getTeam_name().equalsIgnoreCase(teamName)) {
				return Optional.ofNullable(teamStanding);
			}
		}
		return Optional.ofNullable(null);
	}

}
