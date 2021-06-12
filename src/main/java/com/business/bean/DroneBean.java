package com.business.bean;

import org.springframework.stereotype.Component;

@Component
public class DroneBean {
	private boolean droneOccupied;
    private String droneid;
    private boolean toCustomer;
    private boolean toBase;
    private boolean reachedCustomer;
    
	public boolean isDroneOccupied() {
		return droneOccupied;
	}
	public void setDroneOccupied(boolean droneOccupied) {
		this.droneOccupied = droneOccupied;
	}
	public String getDroneid() {
		return droneid;
	}
	public void setDroneid(String droneid) {
		this.droneid = droneid;
	}
	public boolean isToCustomer() {
		return toCustomer;
	}
	public void setToCustomer(boolean toCustomer) {
		this.toCustomer = toCustomer;
	}
	public boolean isToBase() {
		return toBase;
	}
	public void setToBase(boolean toBase) {
		this.toBase = toBase;
	}
	public boolean isReachedCustomer() {
		return reachedCustomer;
	}
	public void setReachedCustomer(boolean reachedCustomer) {
		this.reachedCustomer = reachedCustomer;
	}
}
