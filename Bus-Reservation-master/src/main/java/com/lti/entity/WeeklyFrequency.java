package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="WEEKLY_FREQUENCY")
public class WeeklyFrequency {

	@Id
	@GeneratedValue
	@Column(name="FREQ_ID")
	private int freqId;
	
	@Column(name="MONDAY")
	private Integer monday;
	
	@Column(name="TUESDAY")
	private Integer tuesday;
	
	@Column(name="WEDNESDAY")
	private Integer wednesday;
	
	@Column(name="THURSDAY")
	private Integer thursday;
	
	@Column(name="FRIDAY")
	private Integer friday;
	
	@Column(name="SATURDAY")
	private Integer saturday;
	
	@Column(name="SUNDAY")
	private Integer sunday;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "weeklyFrequency")
	private List<TripDetails> tripDetails;
	
	
	@Override
	public String toString() {
		return "WeeklyFrequency [freqId=" + freqId + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday="
				+ wednesday + ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday="
				+ sunday +  "]";
	}

	public List<TripDetails> getTripDetails() {
		return tripDetails;
	}

	public void setTripDetails(List<TripDetails> tripDetails) {
		this.tripDetails = tripDetails;
	}

	public int getFreqId() {
		return freqId;
	}

	public void setFreqId(int freqId) {
		this.freqId = freqId;
	}

	public int getMonday() {
		return monday;
	}

	public void setMonday(int monday) {
		this.monday = monday;
	}

	public int getTuesday() {
		return tuesday;
	}

	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}

	public int getWednesday() {
		return wednesday;
	}

	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}

	public int getThursday() {
		return thursday;
	}

	public void setThursday(int thursday) {
		this.thursday = thursday;
	}

	public int getFriday() {
		return friday;
	}

	public void setFriday(int friday) {
		this.friday = friday;
	}

	public int getSaturday() {
		return saturday;
	}

	public void setSaturday(int saturday) {
		this.saturday = saturday;
	}

	public int getSunday() {
		return sunday;
	}

	public void setSunday(int sunday) {
		this.sunday = sunday;
	}

	

}
