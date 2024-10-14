package com.hexaware.ticketbookingsystem.dao;

import com.hexaware.ticketbookingsystem.entity.Booking;
import com.hexaware.ticketbookingsystem.entity.Customer;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Venue;

public interface IBookingSystemRepository {
	boolean createEvent(Event event);
	boolean bookTicket(Booking booking);
	boolean cancelTicket(int bookingId);
	boolean addCustomer(Customer customer);
	double calculateBookingCost(int eventId,int numOfTicket);
	boolean getEventDetails();
	boolean createVenue(Venue venue);
	boolean getAvailableTickets(Event event);
	boolean getBookingDetails(int customerId);
}
