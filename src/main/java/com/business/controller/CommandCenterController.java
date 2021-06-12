package com.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.business.service.DroneManager;

@RestController
public class CommandCenterController {
	
	@Autowired
	public DroneManager droneManager; 
	
	@GetMapping(value = "/commandcenter/reachedCustomer/{droneId}")
	public String reachedCustomer(@PathVariable String droneId) {
		return droneManager.reachedForDelivery(droneId); 
	}
	
	@GetMapping(value = "/commandcenter/unloaded/{droneId}")
	public String unLoaded(@PathVariable String droneId) {
		return droneManager.completeDelivery(droneId); 
	}
	
	@GetMapping(value = "/commandcenter/reachedBaseStation/{droneId}")
	public String reachedBase(@PathVariable String droneId) {
		return droneManager.markDroneFree(droneId);
	}	
	
	@GetMapping(value = "/commandcenter/orderPickedUp/{droneId}")
	public String deliveryInitiated(@PathVariable String droneId) {
		return droneManager.assignDroneForDelivery(droneId);
	}
	
	
}
