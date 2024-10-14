package com.hexaware.ticketbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movie extends Event {
	public enum GenreType {
		ACTION, HORROR, COMDEY
	}

	private String actorName;
	private String actressName;
	private GenreType genreType;

	public Movie() {
		super();
	}

	public GenreType getGenreType() {
		return genreType;
	}

	public void setGenreType(GenreType genreType) {
		this.genreType = genreType;
	}

	public Movie(String actorName, String actressName, GenreType genreType) {
		this.actorName = actorName;
		this.actressName = actressName;
		this.genreType = genreType;
	}

	

	public Movie(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime, Venue venueName,
			int totalSeats, int availableSeats, double ticketPrice, EventType eventType) {
		super(eventId, eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice, eventType);
		// TODO Auto-generated constructor stub
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActressName() {
		return actressName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}

	public String eventDetail() {
		System.out.println(super.toString());
		return "Movie [actorName=" + actorName + ", actressName=" + actressName + "]";
	}

	@Override
	public void gettype() {
		// TODO Auto-generated method stub
		 System.out.println("Genre: " + getGenreType());
		
	}
	
}


