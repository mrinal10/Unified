package com.football;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import mockit.Tested;

public class ApiConfigTest {

	@Tested
    ApiConfig properties;	
	
	@Test
    public void TestApiKeyAsSet() {
		properties = new ApiConfig();
		properties.setApikey("test");
		assertEquals(properties.getApikey(), "test");
    }
	
	@Test
    public void TestBaseUrlAsSet() {
		properties = new ApiConfig();
		properties.setBaseurl("test");
		assertEquals(properties.getBaseurl(), "test");
    }
	
	@Test
    public void TestCountryUrlAsSet() {
		properties = new ApiConfig();
		properties.setCountryurl("test");
		assertEquals(properties.getCountryurl(), "test");
    }
	
	@Test
    public void TestLeagueUrlAsSet() {
		properties = new ApiConfig();
		properties.setLeagueurl("test");
		assertEquals(properties.getLeagueurl(), "test");
    }
	
	@Test
    public void TestStandingUrlAsSet() {
		properties = new ApiConfig();
		properties.setStandingurl("test");
		assertEquals(properties.getStandingurl(), "test");
    }
	
	@Test
    public void TestTeamsUrlAsSet() {
		properties = new ApiConfig();
		properties.setTeamsurl("test");
		assertEquals(properties.getTeamsurl(), "test");
    }
}
