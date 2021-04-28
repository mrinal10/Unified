package com.football.controller;

import com.football.entity.*;
import com.football.service.TeamStandingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/football")
public class ApiController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TeamStandingService statusService;
	
	@PostMapping(value = "/teamstanding")
	@ResponseBody
	public Response validateRequest(@RequestBody final Request priorAuthRequest) {
		logger.info("PriorAuthRequest Received");		
		return statusService.getTeamStanding(priorAuthRequest);
	}
}
