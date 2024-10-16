package com.hexaware.ticketbookingsystem.service;

import java.util.List;

import com.hexaware.ticketbookingsystem.dao.BookingSystemServiceProviderImpl;
import com.hexaware.ticketbookingsystem.dao.IBookingSystemRepository;
import com.hexaware.ticketbookingsystem.entity.Booking;
import com.hexaware.ticketbookingsystem.entity.Customer;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Venue;
import com.hexaware.ticketbookingsystem.exception.EventNotFoundException;

public class EventServiceProviderImpl implements IEventServiceProvider {

	private IBookingSystemRepository dao;
	
	
	
	public EventServiceProviderImpl() {
		super();
		dao = new BookingSystemServiceProviderImpl();
	}

	@Override
	public boolean createEvent(Event event) {
		// TODO Auto-generated method stub
		return dao.createEvent(event);
	}

	@Override
	public boolean bookTicket(Booking booking) {
		// TODO Auto-generated method stub
		boolean flag = dao.bookTicket(booking);
		
		if(flag == false) {
			try {

				throw new EventNotFoundException();

			} catch (Exception e) {

				System.err.println("Event Not found for Event ID: " + booking.getEventID());
			}
		}
		return flag;
		
	}

	@Override
	public boolean cancelTicket(int bookingId) {
		// TODO Auto-generated method stub
		return dao.cancelTicket(bookingId);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.addCustomer(customer);
	}

	@Override
	public double calculateBookingCost(int eventId, int numOfTicket) {
		// TODO Auto-generated method stub
		return dao.calculateBookingCost(eventId, numOfTicket);
	}

	@Override
	public List<Event> getEventDetails() {
		// TODO Auto-generated method stub
		return dao.getEventDetails();
	}

	@Override
	public boolean createVenue(Venue venue) {
		// TODO Auto-generated method stub
		return dao.createVenue(venue);
	}

	@Override
	public boolean getAvailableTickets(Event event) {
		// TODO Auto-generated method stub
		return dao.getAvailableTickets(event);
	}

	@Override
	public boolean getBookingDetails(int bookingId) {
		// TODO Auto-generated method stub
		return dao.getBookingDetails(bookingId);
	}
	
	
}
