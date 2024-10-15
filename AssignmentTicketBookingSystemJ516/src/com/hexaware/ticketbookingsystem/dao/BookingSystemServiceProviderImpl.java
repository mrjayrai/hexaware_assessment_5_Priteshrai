package com.hexaware.ticketbookingsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import com.hexaware.ticketbookingsystem.entity.Booking;
import com.hexaware.ticketbookingsystem.entity.Customer;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Venue;
import com.hexaware.ticketbookingsystem.util.DBUtil;

public class BookingSystemServiceProviderImpl implements IBookingSystemRepository {

	private Connection conn;
	
	
	
	public BookingSystemServiceProviderImpl() {
		super();
		conn = DBUtil.getConnection();
	}

	@Override
	public boolean createEvent(Event event) {
		// TODO Auto-generated method stub
		String insertEventQuery = "insert into event (event_id, event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type) values(?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement insertEventQueryStmt = conn.prepareStatement(insertEventQuery);
			insertEventQueryStmt.setInt(1, event.getEventId());
			insertEventQueryStmt.setString(2, event.getEventName());
			insertEventQueryStmt.setDate(3, Date.valueOf( event.getEventDate()));
			insertEventQueryStmt.setTime(4, Time.valueOf( event.getEventTime()));
			insertEventQueryStmt.setInt(5, event.getVenue().getVenueId());
			insertEventQueryStmt.setInt(6, event.getTotalSeats());
			insertEventQueryStmt.setInt(7, event.getAvailableSeats());
			insertEventQueryStmt.setDouble(8, event.getTicketPrice());
			insertEventQueryStmt.setString(9, event.getEventType().name());
			int count = insertEventQueryStmt.executeUpdate();
			return count>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean bookTicket(Booking booking) {
		// TODO Auto-generated method stub
		String insertBookingQuery = "insert into booking(booking_id,customer_id,event_id,num_tickets,total_cost,booking_date) values(?,?,?,?,?,current_date);";
		try {
			PreparedStatement insertBookingQueryStmt = conn.prepareStatement(insertBookingQuery);
			insertBookingQueryStmt.setInt(1, booking.getBookingId());
			insertBookingQueryStmt.setInt(2, booking.getCustomerID().getCustomerId());
			insertBookingQueryStmt.setInt(3, booking.getEventID().getEventId());
			insertBookingQueryStmt.setInt(4, booking.getNumOfTickets());
			insertBookingQueryStmt.setDouble(5, booking.getTotalCost());
			int count = insertBookingQueryStmt.executeUpdate();
			return count>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean cancelTicket(int bookingId) {
		// TODO Auto-generated method stub
		String cancelBookingQuery = "delete from booking where booking_id = ?";
		try {
			PreparedStatement cancelBookingQueryStmt = conn.prepareStatement(cancelBookingQuery);
			cancelBookingQueryStmt.setInt(1, bookingId);
			int count = cancelBookingQueryStmt.executeUpdate();
			return count>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String insertCustomerQuery = "insert into customer (customer_id,customer_name,email,phone_number) values (?,?,?,?);";
		try {
			PreparedStatement insertCustomerQueryStmt = conn.prepareStatement(insertCustomerQuery);
			insertCustomerQueryStmt.setInt(1, customer.getCustomerId());
			insertCustomerQueryStmt.setString(2, customer.getCustomerName());
			insertCustomerQueryStmt.setString(3, customer.getEmail());
			insertCustomerQueryStmt.setString(4, customer.getPhoneNumber());
			int count = insertCustomerQueryStmt.executeUpdate();
			return count>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public double calculateBookingCost(int eventId, int numOfTicket) {
		// TODO Auto-generated method stub
		String ticketPrice = "select ticket_price from event where event_id = ? ;";
		double ticketCost = 0.0;
		try {
			PreparedStatement ticketPriceStmt = conn.prepareStatement(ticketPrice);
			ticketPriceStmt.setInt(1, eventId);
			
			ResultSet result = ticketPriceStmt.executeQuery();
			
			if(result.next()) {
				ticketCost = result.getDouble("ticket_price");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketCost * numOfTicket;
	}

	@Override
	public List<Event> getEventDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createVenue(Venue venue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAvailableTickets(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getBookingDetails(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
