package com.hexaware.ticketbookingsystem.service;

import java.util.List;

import com.hexaware.ticketbookingsystem.entity.Booking;
import com.hexaware.ticketbookingsystem.entity.Customer;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Venue;

public interface IEventServiceProvider {
	boolean createEvent(Event event);
	boolean bookTicket(Booking booking);
	boolean cancelTicket(int bookingId);
	boolean addCustomer(Customer customer);
	double calculateBookingCost(int eventId,int numOfTicket);
	List<Event> getEventDetails();
	boolean createVenue(Venue venue);
	boolean getAvailableTickets(Event event);
	boolean getBookingDetails(int bookingId);
}
