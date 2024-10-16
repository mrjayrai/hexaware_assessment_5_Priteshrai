package com.hexaware.ticketbookingsystem.entity;

import java.time.LocalDate;

public class Booking {
	private int bookingId;
	private int customerID;
	private int eventID;
	private int numOfTickets;
	private double totalCost;
	private LocalDate bookingDate;
	
	public Booking() {
		super();
	}

	public Booking(int bookingId, int customerID, int eventID, int numOfTickets,double totalCost) {
		super();
		this.bookingId = bookingId;
		this.customerID = customerID;
		this.eventID = eventID;
		this.numOfTickets = numOfTickets;
		this.totalCost = totalCost;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
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
