package com.hexaware.ticketbookingsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.ticketbookingsystem.entity.Booking;
import com.hexaware.ticketbookingsystem.entity.Concert;
import com.hexaware.ticketbookingsystem.entity.Customer;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Movie;
import com.hexaware.ticketbookingsystem.entity.Sport;
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
	    List<Event> eventList = new ArrayList<>();
	    String getEventQuery = "SELECT * FROM event;";
	    
	    try {
	        PreparedStatement getEventQueryStmt = conn.prepareStatement(getEventQuery);
	        ResultSet result = getEventQueryStmt.executeQuery();
	        
	        while (result.next()) {
	            int eventId = result.getInt("event_id");
	            String eventName = result.getString("event_name");
	            LocalDate eventDate = result.getDate("event_date").toLocalDate();
	            LocalTime eventTime = result.getTime("event_time").toLocalTime();
//	            Venue venue = new Venue(result.getString("venue_name"), result.getString("venue_address"));
	            Venue venue = null;
	            int venueId = result.getInt("venue_id");
	            int totalSeats = result.getInt("total_seats");
	            int availableSeats = result.getInt("available_seats");
	            double ticketPrice = result.getDouble("ticket_price");
	            String eventTypeStr = result.getString("event_type");
	            Event.EventType eventType = Event.EventType.valueOf(eventTypeStr.toUpperCase());

	            Event event;

	            switch (eventType) {
	                case MOVIE:
	                    String actorName = result.getString("actor_name");
	                    String actressName = result.getString("actress_name");
	                    Movie.GenreType genreType = Movie.GenreType.valueOf(result.getString("genre_type").toUpperCase());
	                    Movie movieEvent = new Movie(eventId, eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice, eventType);
	                    movieEvent.setActorName(actorName);
	                    movieEvent.setActressName(actressName);
	                    movieEvent.setGenreType(genreType);
	                    movieEvent.setVenueId(venueId);
	                    event = movieEvent;
	                    break;

	                case CONCERT:
	                    String artistName = result.getString("artist_name");
	                    Concert.ConcertType concertType = Concert.ConcertType.valueOf(result.getString("concert_type").toUpperCase());
	                    Concert concertEvent = new Concert(eventId, eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice, eventType);
	                    concertEvent.setArtistName(artistName);
	                    concertEvent.setConcertType(concertType);
	                    concertEvent.setVenueId(venueId);
	                    event = concertEvent;
	                    break;

	                case SPORTS:
	                    String sportName = result.getString("sport_name");
	                    String teamsName = result.getString("teams_name");
	                    Sport sportEvent = new Sport(eventId, eventName, eventDate, eventTime, venue, totalSeats, availableSeats, ticketPrice, eventType);
	                    sportEvent.setSportName(sportName);
	                    sportEvent.setTeamsName(teamsName);
	                    sportEvent.setVenueId(venueId);
	                    event = sportEvent;
	                    break;

	                default:
	                    throw new IllegalArgumentException("Unknown event type: " + eventType);
	            }
	            
	            eventList.add(event);
	        }
	        
	        result.close();
	        getEventQueryStmt.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return eventList;
	}


	@Override
	public boolean createVenue(Venue venue) {
		// TODO Auto-generated method stub
		String insertVenueQuery = "insert into venue(venue_id,venue_name,address) values (?,?,?);";
		
		try {
			PreparedStatement insertVenueQueryStmt = conn.prepareStatement(insertVenueQuery);
			insertVenueQueryStmt.setInt(1, venue.getVenueId());
			insertVenueQueryStmt.setString(2, venue.getVenueName());
			insertVenueQueryStmt.setString(3, venue.getAddress());
			int count = insertVenueQueryStmt.executeUpdate();
			return count>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean getAvailableTickets(Event event) {
		// TODO Auto-generated method stub
		String getTicketQuery = "select available_seats from event where event_id = ?;";
		try {
			PreparedStatement getTicketQueryStmt = conn.prepareStatement(getTicketQuery);
			getTicketQueryStmt.setInt(1, event.getEventId());
			
			ResultSet result = getTicketQueryStmt.executeQuery();
			if(result.next()) {
				System.out.println(result.getInt("available_seats")+"ticket's are available");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean getBookingDetails(int bookingId) {
		// TODO Auto-generated method stub
		String getBooking = "select b.booking_id,c.customer_name,e.event_name,e.event_date,v.venue_name,b.num_tickets,b.total_cost"
				+ "from booking b"
				+ "join customer c on c.customer_id = b.customer_id"
				+ "join event e on e.event_id = b.event_id"
				+ "join venue v on v.venue_id = e.venue_id"
				+ "where b.booking_id = ?;";
		try {
			PreparedStatement getBookingStmt = conn.prepareStatement(getBooking);
			getBookingStmt.setInt(1, bookingId);
			ResultSet result = getBookingStmt.executeQuery();
			if (result.next()) {
	            String customerName = result.getString("customer_name");
	            String eventName = result.getString("event_name");
	            LocalDate eventDate = result.getDate("event_date").toLocalDate();
	            String venueName = result.getString("venue_name");
	            int numTickets = result.getInt("num_tickets");
	            double totalCost = result.getDouble("total_cost");
	            
	            // Print or process the booking details
	            System.out.println("Booking ID: " + bookingId);
	            System.out.println("Customer Name: " + customerName);
	            System.out.println("Event Name: " + eventName);
	            System.out.println("Event Date: " + eventDate);
	            System.out.println("Venue Name: " + venueName);
	            System.out.println("Number of Tickets: " + numTickets);
	            System.out.println("Total Cost: " + totalCost);
	            
	            return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
