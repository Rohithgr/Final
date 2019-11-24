package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lti.enums.Gender;

@Entity
@Table(name="GUEST_CUSTOMER")
public class GuestCustomer {

	@Id
	@GeneratedValue
	private int guestID;
	
	@Column(name="GUEST_NAME")
	private String name;
	
	@Column(name="GENDER")
	private Gender gender;
	
	@JoinColumn(name="RESRV_ID")
	@ManyToOne
	private ReservationDetails reservation;
	
	@JoinColumn(name="SEAT_ID")
	@OneToOne
	private SeatDetails seat;
	

	public SeatDetails getSeat() {
		return seat;
	}

	public void setSeat(SeatDetails seat) {
		this.seat = seat;
	}

	public int getGuestID() {
		return guestID;
	}

	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ReservationDetails getReservation() {
		return reservation;
	}

	public void setReservation(ReservationDetails reservation) {
		this.reservation = reservation;
	}
	
	
	
}
