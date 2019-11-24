package com.lti.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="RESERVATION_DETAILS")
public class ReservationDetails {

	@Id
	@GeneratedValue
	@Column(name="RESRV_ID")
	private int resrvID;
	
	@OneToOne
	@JoinColumn(name="TRIP_ID")
	@JsonIgnore
	private TripDetails trip;
	
	@Column(name="SEATS_RESERVED")
	private int seats;
	
	@Column(name="TOTAL_COST")
	private double price;
	
	@Column(name="RESERVED_ON")
	private String reservedOn;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "reservation")
	private List<GuestCustomer> guest;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getReservedOn() {
		return reservedOn;
	}

	public void setReservedOn(String reservedOn) {
		this.reservedOn = reservedOn;
	}

	public List<GuestCustomer> getGuest() {
		return guest;
	}

	public void setGuest(List<GuestCustomer> guest) {
		this.guest = guest;
	}

	public int getResrvID() {
		return resrvID;
	}

	public void setResrvID(int resrvID) {
		this.resrvID = resrvID;
	}

	public TripDetails getTrip() {
		return trip;
	}

	public void setTrip(TripDetails trip) {
		this.trip = trip;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "ReservationDetails [resrvID=" + resrvID + ", trip=" + trip + ", seats=" + seats + ", price=" + price
				+ ", reservedOn=" + reservedOn + ", guest=" + guest + "]";
	}
	
	
	
}
