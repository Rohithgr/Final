package com.lti.DTO;

import java.util.List;

public class TicketDTO {

	private int reservID;
	private int noOfSeats;
	private List<Integer> s;
	public List<Integer> getS() {
		return s;
	}
	public void setS(List<Integer> s) {
		this.s = s;
	}
	public int getReservID() {
		return reservID;
	}
	public void setReservID(int reservID) {
		this.reservID = reservID;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
}
