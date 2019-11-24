package com.lti.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BUS_DAILY_TIME_TABLE")
public class BusTimeTable {

	@Id
	@GeneratedValue
	@Column(name="JOURNEY_ID")
	private int journeyID;
	
	@ManyToOne
	@JoinColumn(name="TRIP_ID")
	private TripDetails trip;
	
	@Column(name="JOURNEY_DATE")
	private Date date;
	
	@Column(name="SEATS_FREE")
	private int seatsFree;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "bus")
	private List<SeatDetails> seats;
	
	
	public List<SeatDetails> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatDetails> seats) {
		this.seats = seats;
	}
	public int getJourneyID() {
		return journeyID;
	}
	public void setJourneyID(int journeyID) {
		this.journeyID = journeyID;
	}
	public int getSeatsFree() {
		return seatsFree;
	}
	public void setSeatsFree(int seatsFree) {
		this.seatsFree = seatsFree;
	}
	public int getTimeID() {
		return journeyID;
	}
	public void setTimeID(int journeyID) {
		this.journeyID = journeyID;
	}
	public TripDetails getTrip() {
		return trip;
	}
	public void setTrip(TripDetails trip) {
		this.trip = trip;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
}
