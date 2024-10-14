package com.hexaware.ticketbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {
	private int eventId;
	private String eventName;
	private LocalDate eventDate;
	private LocalTime eventTime;
	private Venue venueName;
	private int totalSeats;
	private int availableSeats;
	private double ticketPrice;
	private EventType eventType;
	
	public enum EventType{
		MOVIE, SPORTS, CONCERT
	}

	public Event() {
		super();
	}

	

	public Event(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime, Venue venueName,
			int totalSeats, int availableSeats, double ticketPrice, EventType eventType) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.venueName = venueName;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.ticketPrice = ticketPrice;
		this.eventType = eventType;
	}



	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

	public String getVenueName() {
		return venueName.getVenueName();
	}

	public void setVenueName(Venue venueName) {
		this.venueName = venueName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
		this.availableSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", eventDate=" + eventDate + ", eventTime=" + eventTime
				+ ", venueName=" + venueName + ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats
				+ ", ticketPrice=" + ticketPrice + ", eventType=" + eventType + "]";
	}

	public double calculateTotalRevenue() {
		int ticketSold = totalSeats-availableSeats;
		
		return ticketPrice * ticketSold;
	}
	
	public int getBookedNoOfTickets() {
		return totalSeats-availableSeats;
	}

	public boolean bookTickets(int numTickets) {
		if(numTickets<=availableSeats) {
			availableSeats -=numTickets;
			System.out.println("Ticket Booked Successfully");
			return true;
		}else {
			System.out.println("Ticket unavailable. Only " + availableSeats + " tickets available.");
			return false;
		}
	}
	
	public void bookingCost(int numTickets) {
		System.out.println("The booking cost for "+numTickets+" of tickets will be : " + numTickets*ticketPrice );
	}
	
	public void cancelBooking(int numTickets) {
		if(numTickets<= (totalSeats-availableSeats)) {
		availableSeats +=numTickets;
		System.out.println("Tickets cancelled Successfully");
		bookingCost(totalSeats-availableSeats);
		}else {
			System.out.println("Please Choose Valid number of tickets");
		}
	}
	
	public abstract void gettype() ;
	
	
	
}

