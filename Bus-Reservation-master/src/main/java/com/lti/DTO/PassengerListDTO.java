package com.lti.DTO;


public class PassengerListDTO {

	private Passengers[] passengers;
	private int tripID;
	private String journeyDate;
	private Integer customerId;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Passengers[] getPassengers() {
		return passengers;
	}
	public void setPassengers(Passengers[] passengers) {
		this.passengers = passengers;
	}
	public int getTripID() {
		return tripID;
	}
	public void setTripID(int tripID) {
		this.tripID = tripID;
	}
	
}
