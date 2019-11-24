package com.lti.DTO;


public class UpdateBusDTO {
	
	private String transportCompanyName;
	private int seats;
	private String bustype;
	private String startOfService;
	private String endOfSerivce;
	
	public String getTransportCompanyName() {
		return transportCompanyName;
	}
	public void setTransportCompanyName(String transportCompanyName) {
		this.transportCompanyName = transportCompanyName;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public String getStartOfService() {
		return startOfService;
	}
	public void setStartOfService(String startOfService) {
		this.startOfService = startOfService;
	}
	public String getEndOfSerivce() {
		return endOfSerivce;
	}
	public void setEndOfSerivce(String endOfSerivce) {
		this.endOfSerivce = endOfSerivce;
	}
	@Override
	public String toString() {
		return "UpdateBusDTO [transportCompanyName=" + transportCompanyName + ", bustype=" + bustype + ", seats="
				+ seats + ", startOfService=" + startOfService + ", endOfSerivce=" + endOfSerivce + "]";
	}
	
}
