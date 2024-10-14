package com.hexaware.ticketbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event {
	private String artistName;
	private ConcertType concertType;

	public enum ConcertType {
		THEARTICAL, CLASSICAL, ROCK, RECITAL
	}

	public Concert(String artistName, ConcertType concertType) {
		super();
		this.artistName = artistName;
		this.concertType = concertType;
	}

	public Concert() {
		super();
	}

	

	public Concert(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime, Venue venueName,
			int totalSeats, int availableSeats, double ticketPrice, EventType eventType) {
		super(eventId, eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice, eventType);
		// TODO Auto-generated constructor stub
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public ConcertType getConcertType() {
		return concertType;
	}

	public void setConcertType(ConcertType concertType) {
		this.concertType = concertType;
	}
	
	public String concertDetail() {
		System.out.println(super.toString());
		return "Concert [artistName=" + artistName + ", concertType=" + concertType + "]";
	}

	@Override
	public void gettype() {
		// TODO Auto-generated method stub
		 System.out.println("Concert Type: " + getConcertType());
		
	}

	
	
	

}

