package com.reputation.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reputation.demo.model.FundData;

@Service 
public class Httpservice {

	@Autowired
	RestTemplate restTemplate;

	private String responseUrl = "https://api.mfapi.in/mf/";

	public FundData getResponse(String schemeId) {
		String schemeUrl = responseUrl + schemeId;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(schemeUrl, HttpMethod.GET, entity, FundData.class).getBody();
	}
}
