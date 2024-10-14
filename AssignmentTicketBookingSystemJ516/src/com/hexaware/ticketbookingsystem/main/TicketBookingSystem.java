package com.hexaware.ticketbookingsystem.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.Concert;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Event.EventType;
import com.hexaware.ticketbookingsystem.entity.Movie;
import com.hexaware.ticketbookingsystem.entity.Sport;
import com.hexaware.ticketbookingsystem.entity.Venue;


public class TicketBookingSystem extends BookingSystem {

	private List<Event> events;

	public TicketBookingSystem() {
		super();
		this.events = new ArrayList<>();
	}
	
	@Override
	public Event createEvent(int eventId,String eventName, LocalDate eventDate, LocalTime eventTime, Venue venueName,
			int totalSeats, double ticketPrice, Event.EventType eventType) {

		
		switch (eventType) {
        case MOVIE:
        	
        	Scanner sc = new Scanner(System.in);
        	System.out.println("Enter Actor Name: ");
        	String actorName = sc.next();
        	sc.nextLine();
        	System.out.println("Enter Actress Name: ");
        	String actressName = sc.next();
        	sc.nextLine();
        	System.out.println("Choose Genre Type: \n1 for Action \n2 for Horror \n3 for Comedy");
            int genreChoice = sc.nextInt();
            sc.nextLine();
            Movie.GenreType genreType = Movie.GenreType.values()[genreChoice - 1];
        	Movie movieEvent = new Movie(eventId,eventName, eventDate, eventTime, venueName, totalSeats, totalSeats, ticketPrice, eventType);
            movieEvent.setActorName(actorName);
            movieEvent.setActressName(actressName);
            movieEvent.setGenreType(genreType);
            events.add(movieEvent);
            return movieEvent;

        case CONCERT:
        	Scanner scConcert = new Scanner(System.in);
        	System.out.println("Enter Artist Name: ");
        	String artistName = scConcert.next();
        	scConcert.nextLine();
        	System.out.println("Choose Genre Type: \n1 for THEARTICAL \n2 for CLASSICAL \n3 for ROCK \n4 for RECITAL");
            int concertChoice = scConcert.nextInt();
            scConcert.nextLine();
            Concert.ConcertType concertType = Concert.ConcertType.values()[concertChoice-1];
            Concert concertEvent = new Concert(eventId,eventName, eventDate, eventTime, venueName, totalSeats, totalSeats, ticketPrice, eventType);
            concertEvent.setArtistName(artistName);
            concertEvent.setConcertType(concertType);
            events.add(concertEvent);
            return concertEvent;

        case SPORTS:
        	Scanner scSport = new Scanner(System.in);
        	System.out.println("Enter Sports Name: ");
        	String sportName = scSport.next();
        	scSport.nextLine();
        	System.out.println("Enter Teams Name: ");
        	String TeamsName = scSport.next();
        	scSport.nextLine();
            Sport sportEvent = new Sport(eventId,eventName, eventDate, eventTime, venueName, totalSeats, totalSeats, ticketPrice, eventType);
            sportEvent.setSportName(sportName);
            sportEvent.setTeamsName(TeamsName);
            events.add(sportEvent);
            return sportEvent;

        default:
            throw new IllegalArgumentException("Invalid event type: " + eventType);
    }
		

	}
	
	
	
	public void displayEventDetail(Event event) {
		System.out.println(event.toString());
	}

	

	public double bookTickets(Event event, int numOfTickets) {
		Boolean success = event.bookTickets(numOfTickets);
		if (success) {
			double ticketCost = numOfTickets * event.getTicketPrice();
			event.bookingCost(numOfTickets);
			return ticketCost;
		}
		return 0;
	}

	public void cancelTickets(Event event, int numOfTickets) {
		event.cancelBooking(numOfTickets);
	}
	
	private Event getEventById(int eventId) {
		for(Event eventDetail:events) {
			if(eventDetail.getEventId() == eventId) {
				return eventDetail;
			}
		}
		return null;
	}
	
	private void eventNames() {
		for(Event eventDetail:events) {
			System.out.println("Event ID: "+eventDetail.getEventId()+" Event Name: "+eventDetail.getEventName());
		}
	}
	
	private void eventDetail(Event event) {
		System.out.println("Event Details:");
	    System.out.println("Event ID: " + event.getEventId());
	    System.out.println("Event Name: " + event.getEventName());
	    System.out.println("Event Date: " + event.getEventDate());
	    System.out.println("Event Time: " + event.getEventTime());
	    System.out.println("Venue Name: " + event.getVenueName());
	    System.out.println("Total Seats: " + event.getTotalSeats());
	    System.out.println("Available Seats: " + event.getAvailableSeats());
	    System.out.println("Ticket Price: " + event.getTicketPrice());
	    System.out.println("Event Type: " + event.getEventType());
	    
	    if (event instanceof Movie) {
	        Movie movie = (Movie) event;
	        System.out.println("Actor: " + movie.getActorName());
	        System.out.println("Actress: " + movie.getActressName());
//	        System.out.println("Genre: " + movie.gettype());
	        movie.gettype();
	    }
	    // Check if the event is of type Sports
	    else if (event instanceof Sport) {
	        Sport sports = (Sport) event;
	        System.out.println("Team Name: " + sports.getTeamsName());
//	        System.out.println("Sport Name: " + sports.getSportName());
	        sports.gettype();
	    }
	    // Check if the event is of type Concert
	    else if (event instanceof Concert) {
	        Concert concert = (Concert) event;
	        System.out.println("Performer: " + concert.getArtistName());
//	        System.out.println("Concert Type: " + concert.getConcertType());
	        concert.gettype();
	    }
	}

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		TicketBookingSystem ticketBookingSystem = new TicketBookingSystem();
		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Create Event");
			System.out.println("2. View Event Details");
			System.out.println("3. Book Tickets");
			System.out.println("4. Cancel Tickets");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Event ID: ");
				int eventid = scanner.nextInt();
				System.out.println("Enter Event Name: ");
				String eventName = scanner.next();
				scanner.nextLine();
				System.out.println("Enter Event Date (YYYY-MM-DD): ");
				String eventDate = scanner.next();
				scanner.nextLine();
				System.out.println("Enter Event Time (HH:MM) please follow 24 hour clock: ");
				String eventTime = scanner.next();
				scanner.nextLine();
				System.out.println("Enter Venue Name: ");
				String venueName = scanner.next();
				scanner.nextLine();
				System.out.println("Enter the total Number of seats: ");
				int totalSeats = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Ticket Price: ");
				double ticketPrice = scanner.nextDouble();
				scanner.nextLine();
				System.out
						.println("Choose Event Type \n" + "\n 1 for Movies" + "\n 2 for Sports" + "\n 3 for Concert ");
				int eventTypeChoice = scanner.nextInt();
				scanner.nextLine();
				Event.EventType eventType = Event.EventType.values()[eventTypeChoice - 1];
				Venue venueObj = new Venue();
				venueObj.setVenueName(venueName);
				switch (eventType) {
                case MOVIE:
                    
                    
                    // Create Movie event
                    Event movieEvent = ticketBookingSystem.createEvent(eventid,eventName, LocalDate.parse(eventDate),
                            LocalTime.parse(eventTime), venueObj, totalSeats, ticketPrice, eventType);
                    
                    System.out.println("Movie Event Created Successfully: " + movieEvent.getEventName());
                    break;

                case SPORTS:
                    // Create Sport event
                    Event sportEvent = ticketBookingSystem.createEvent(eventid,eventName, LocalDate.parse(eventDate),
                            LocalTime.parse(eventTime), venueObj, totalSeats, ticketPrice, eventType);
                    System.out.println("Sport Event Created Successfully: " + sportEvent.getEventName());
                    break;

                case CONCERT:
                    // Create Concert event
                    Event concertEvent = ticketBookingSystem.createEvent(eventid,eventName, LocalDate.parse(eventDate),
                            LocalTime.parse(eventTime), venueObj, totalSeats, ticketPrice, eventType);
                    System.out.println("Concert Event Created Successfully: " + concertEvent.getEventName());
                    break;

                default:
                    System.out.println("Invalid event type.");
                    break;
            }
//				Event event = ticketBookingSystem.createEvent(eventName, LocalDate.parse(eventDate),
//						LocalTime.parse(eventTime), venueName, totalSeats, ticketPrice, eventType);
//				System.out.println("Event Created Successfully: " + event.getEventName());
				break;
			case 2:
				if(ticketBookingSystem.events.isEmpty()) {
					System.out.println("No Event Details Available");
				}else {
					System.out.println("Choose the event ID to choose event details");
					ticketBookingSystem.eventNames();
					int eventIdDetail = scanner.nextInt();
					Event eventDetailObj = ticketBookingSystem.getEventById(eventIdDetail);
					if(eventDetailObj ==null) {
						System.out.println("Invalid event id selected");
					}else {
					ticketBookingSystem.eventDetail(eventDetailObj);
					}
				}
				break;
			case 3:
				if(ticketBookingSystem.events.isEmpty()) {
					System.out.println("No events Available");
				}else {
					System.out.println("Available Events: ");
					int index = 1;
					for(Event eventDet:ticketBookingSystem.events) {
						System.out.println(index+ ". "+ eventDet.getEventName()+" price: "+eventDet.getTicketPrice());
						index++;
					}
					
					System.out.println("\n Choose the event Number: ");
					int eventNumber = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the number of tickets: ");
					int numOfTicket = scanner.nextInt();
					
					ticketBookingSystem.bookTickets(ticketBookingSystem.events.get(eventNumber -1), numOfTicket);
				}
				
				break;
			case 4:
				if(ticketBookingSystem.events.isEmpty()) {
					System.out.println("No Event Available for ticket cancellation");
				}else {
					System.out.println("Available Events: ");
					int index = 1;
					for(Event eventDet:ticketBookingSystem.events) {
						System.out.println(index+ ". "+ eventDet.getEventName()+" price: "+eventDet.getTicketPrice());
						index++;
					}
					System.out.println("Enter event number to cancel tickets: ");
                    int eventIndex = scanner.nextInt() - 1;
                    System.out.print("Enter number of tickets to cancel: ");
                    int numTickets = scanner.nextInt();
                   ticketBookingSystem.cancelTickets(ticketBookingSystem.events.get(eventIndex), numTickets);
				}
				break;
			case 5:
				System.out.println("Exiting the ticket booking system.");
				scanner.close();
				return;
			default:
				break;
			}
		}
	}

}
