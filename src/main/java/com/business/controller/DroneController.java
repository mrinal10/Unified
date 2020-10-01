package com.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.business.service.DroneManager;

@RestController
public class DroneController {
	
	@Autowired
	public DroneManager droneManager;
	
	@GetMapping(value = "/drone/callfordelivery/{droneId}/{location}")
	public String upForDelivery(@PathVariable String droneId, 
						@PathVariable String location) {
		return droneManager.assignDrone(droneId);
	}
}
