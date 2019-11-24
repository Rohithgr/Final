package com.lti.entity;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="SEAT_DETAILS")
public class SeatDetails {

	@Id
	@GeneratedValue
	@Column(name="SEAT_ID")
	private int seatID;
	
	@JoinColumn(name="JOURNEY_ID")
	@ManyToOne
	private BusTimeTable bus;
	
	@Column(name="SEAT_NO")
	private int seatNo;
	
	@Column(name="IS_FREE")
	private boolean isFree;


	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	public BusTimeTable getBus() {
		return bus;
	}

	public void setBus(BusTimeTable bus) {
		this.bus = bus;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}


	

}
