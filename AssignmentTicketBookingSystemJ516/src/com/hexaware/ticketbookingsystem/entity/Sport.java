package com.hexaware.ticketbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sport extends Event {

	private String sportName;
	private String teamsName;

	public Sport() {
		super();
	}

	public Sport(String sportName, String teamsName) {
		super();
		this.sportName = sportName;
		this.teamsName = teamsName;
	}

	

	public Sport(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime, Venue venueName,
			int totalSeats, int availableSeats, double ticketPrice, EventType eventType) {
		super(eventId, eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice, eventType);
		// TODO Auto-generated constructor stub
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getTeamsName() {
		return teamsName;
	}

	public void setTeamsName(String teamsName) {
		this.teamsName = teamsName;
	}

	public String sportDetails() {
		System.out.println(super.toString());
		return "Sport [sportName=" + sportName + ",teamsName=" + teamsName + "]";
	}

	@Override
	public void gettype() {
		// TODO Auto-generated method stub
		 System.out.println("Sport: " + getSportName());
		
	}
	
	

}

