package com.football.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.football.ApiConfig;


@Component
public class ProjectUtil {
	
	@Autowired
	ApiConfig apiconfig;

	public String getcountryDetails() {
		String url = apiconfig.getBaseurl() + apiconfig.getCountryurl() + apiconfig.getApikey();
		try {
			return getRes(url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return "";
	}
	
	public String getLeagueDetails(String countryId){
		String url = apiconfig.getBaseurl() + apiconfig.getLeagueurl() + countryId + apiconfig.getApikey();
		try {
			return getRes(url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	public String getTeamStanding(String leagueId) {
		String url = apiconfig.getBaseurl() + apiconfig.getStandingurl() + leagueId + apiconfig.getApikey();
		try {
			return getRes(url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return "";
	}
	
	private String getRes(String url) throws IOException {
		URL curUrl = new URL(url);
        URLConnection yc = curUrl.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        StringBuilder otpt  = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            otpt.append(inputLine);
        }
        in.close();
        return otpt.toString();
	}

}
