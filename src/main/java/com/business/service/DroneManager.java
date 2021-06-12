package com.business.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.bean.DroneBean;
import com.business.rule.util.ConfigUtil;

@Service
public class DroneManager {

	@Autowired
	public ConfigUtil configUtil;

	public synchronized String assignDrone(String droneId) {
		String response = validateDrone(droneId);
		if (!response.isEmpty())
			return response;
		droneStateSwitcher(droneId, true, false, false, false);
		return "Drone Assigned";
	}

	public synchronized String assignDroneForDelivery(String droneId) {
		String response = validateDrone(droneId);
		if (!response.isEmpty())
			return response;
		droneStateSwitcher(droneId, true, true, false, false);
		return "Drone On the way to customer";
	}

	public synchronized String reachedForDelivery(String droneId) {
		String response = validateDrone(droneId);
		if (!response.isEmpty())
			return response;
		droneStateSwitcher(droneId, true, false, true, true);
		return "Drone reached customer";
	}

	public synchronized String completeDelivery(String droneId) {
		String response = validateDrone(droneId);
		if (!response.isEmpty())
			return response;
		droneStateSwitcher(droneId, true, false, true, true);
		return "Drone On the way to customer";
	}

	public String markDroneFree(String droneId) {
		Map<String, DroneBean> droneMap = configUtil.getDrones();
		DroneBean targetDrone = droneMap.get(droneId);
		if (targetDrone == null) {
			return "no such drone";
		} else if (!targetDrone.isDroneOccupied()) {
			return "Drone Already Free";
		}
		droneStateSwitcher(droneId, false, false, false, false);
		return "Drone Freed";
	}

	private void droneStateSwitcher(String droneId, boolean isDroneOccupied, boolean isToBase, boolean isToCustomer,
			boolean reachedCustomer) {
		Map<String, DroneBean> droneMap = configUtil.getDrones();
		DroneBean targetDrone = droneMap.get(droneId);
		targetDrone.setDroneOccupied(isDroneOccupied);
		targetDrone.setToBase(isToBase);
		targetDrone.setToCustomer(isToCustomer);
		targetDrone.setReachedCustomer(reachedCustomer);
		droneMap.put(droneId, targetDrone);
	}

	private String validateDrone(String droneId) {
		Map<String, DroneBean> droneMap = configUtil.getDrones();
		DroneBean targetDrone = droneMap.get(droneId);
		if (targetDrone == null) {
			return "no such drone";
		} else if (targetDrone.isDroneOccupied()) {
			return "Drone Busy";
		}
		return "";
	}
}
