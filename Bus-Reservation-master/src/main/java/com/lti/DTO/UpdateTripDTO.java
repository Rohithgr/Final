package com.lti.DTO;

import java.time.LocalTime;

public class UpdateTripDTO {

	private int busID;
	private int routeID;
	private int freqID;
	private String departureTime;
	private String arrivalTime;
	
	public int getBusID() {
		return busID;
	}
	public void setBusID(int busID) {
		this.busID = busID;
	}
	public int getRouteID() {
		return routeID;
	}
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	public int getFreqID() {
		return freqID;
	}
	public void setFreqID(int freqID) {
		this.freqID = freqID;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
}
