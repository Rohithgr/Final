package com.lti.DTO;

import java.time.LocalTime;

import com.lti.entity.TransportCompany;

public class BusResultDTO {

	private int tripId;
	private  String departureTime;
	private  String arrivalTime;
	private int seatsFree;
	private String busType;
	private String transportCompanyName;
	private int duration;
	private double fare;
	
	
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "BusResultDTO [tripId=" + tripId + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", seatsFree=" + seatsFree + ", busType=" + busType + ", transportCompanyName=" + transportCompanyName
				+ "]";
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
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
	public int getSeatsFree() {
		return seatsFree;
	}
	public void setSeatsFree(int seatsFree) {
		this.seatsFree = seatsFree;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getTransportCompanyName() {
		return transportCompanyName;
	}
	public void setTransportCompanyName(String transportCompanyName) {
		this.transportCompanyName = transportCompanyName;
	}
}
