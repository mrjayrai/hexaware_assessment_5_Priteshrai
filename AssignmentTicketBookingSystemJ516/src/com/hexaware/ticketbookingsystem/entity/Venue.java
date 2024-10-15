package com.hexaware.ticketbookingsystem.entity;

public class Venue {

	private String venueName;
	private String address;
	private int venueId;
	
	
	
	public Venue(String venueName, String address, int venueId) {
		super();
		this.venueName = venueName;
		this.address = address;
		this.venueId = venueId;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public Venue() {
		super();
	}

	

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public void displayVenueDetails() {
		System.out.println("Venue [venueName=" + venueName + ", address=" + address + "]");
	}
	
	
	
}

