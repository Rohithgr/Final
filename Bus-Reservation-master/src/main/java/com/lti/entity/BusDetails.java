package com.lti.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BUS_DETAILS")
public class BusDetails {


	@Id
	@GeneratedValue
	@Column(name="BUS_ID")
	private int busId;
	
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private TransportCompany transportCompany;
	
	@Column(name="TOTAL_SEATS")
	private int totalSeats;
	
	@Column(name="BUS_TYPE")
	private String busType;
	
	@Column(name="START_OF_SERVICE")
	private Date startOfService;
	
	@Column(name="END_OF_SERVICE")
	private Date endOfService;
	
	
	@Override
	public String toString() {
		return "BusDetails [busId=" + busId + ", transportComapny=" + transportCompany + ", totalSeats=" + totalSeats
				+ ", busType=" + busType + ", startOfService=" + startOfService + ", endOfService=" + endOfService
				+ "]";
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public TransportCompany getTransportComapny() {
		return transportCompany;
	}

	public void setTransportCompany(TransportCompany transportCompany) {
		this.transportCompany = transportCompany;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public Date getStartOfService() {
		return startOfService;
	}

	public void setStartOfService(Date startOfService) {
		this.startOfService = startOfService;
	}

	public Date getEndOfService() {
		return endOfService;
	}

	public void setEndOfService(Date endOfService) {
		this.endOfService = endOfService;
	}

	
	
}
