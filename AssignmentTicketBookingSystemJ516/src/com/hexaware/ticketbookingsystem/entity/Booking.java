package com.hexaware.ticketbookingsystem.entity;

import java.time.LocalDate;

public class Booking {
	private int bookingId;
	private Customer customerID;
	private Event eventID;
	private int numOfTickets;
	private double totalCost;
	private LocalDate bookingDate;
	
	public Booking() {
		super();
	}

	public Booking(int bookingId, Customer customerID, Event eventID, int numOfTickets, double totalCost,
			LocalDate bookingDate) {
		super();
		this.bookingId = bookingId;
		this.customerID = customerID;
		this.eventID = eventID;
		this.numOfTickets = numOfTickets;
		this.totalCost = totalCost;
		this.bookingDate = bookingDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Customer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	public Event getEventID() {
		return eventID;
	}

	public void setEventID(Event eventID) {
		this.eventID = eventID;
	}

	public int getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(int numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	
	
}
