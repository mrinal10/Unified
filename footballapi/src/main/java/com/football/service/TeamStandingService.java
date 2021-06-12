package com.football.service;

import com.football.entity.Request;
import com.football.entity.Response;

public interface TeamStandingService {
	public Response getTeamStanding(Request customReq);
}
