package com.hexaware.ticketbookingsystem.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.Concert;
import com.hexaware.ticketbookingsystem.entity.Customer;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Movie;
import com.hexaware.ticketbookingsystem.entity.Sport;
import com.hexaware.ticketbookingsystem.entity.Venue;
import com.hexaware.ticketbookingsystem.service.EventServiceProviderImpl;
import com.hexaware.ticketbookingsystem.service.IEventServiceProvider;

public class TicketBookingSystemDB {
	static Scanner scanner = new Scanner(System.in);

	public static int generateBookingID() {
		long timestamp = System.currentTimeMillis() / 1000;

		Random random = new Random();
		int randomNum = random.nextInt(900) + 100;

		long bookingIdLong = timestamp % 100000 + randomNum;
		return (int) bookingIdLong;
	}

	public Event createEvent(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime, Venue venueName,
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
			Movie movieEvent = new Movie(eventId, eventName, eventDate, eventTime, venueName, totalSeats, totalSeats,
					ticketPrice, eventType);
			movieEvent.setActorName(actorName);
			movieEvent.setActressName(actressName);
			movieEvent.setGenreType(genreType);
//            events.add(movieEvent);
			return movieEvent;

		case CONCERT:
			Scanner scConcert = new Scanner(System.in);
			System.out.println("Enter Artist Name: ");
			String artistName = scConcert.next();
			scConcert.nextLine();
			System.out.println("Choose Genre Type: \n1 for THEARTICAL \n2 for CLASSICAL \n3 for ROCK \n4 for RECITAL");
			int concertChoice = scConcert.nextInt();
			scConcert.nextLine();
			Concert.ConcertType concertType = Concert.ConcertType.values()[concertChoice - 1];
			Concert concertEvent = new Concert(eventId, eventName, eventDate, eventTime, venueName, totalSeats,
					totalSeats, ticketPrice, eventType);
			concertEvent.setArtistName(artistName);
			concertEvent.setConcertType(concertType);
//            events.add(concertEvent);
			return concertEvent;

		case SPORTS:
			Scanner scSport = new Scanner(System.in);
			System.out.println("Enter Sports Name: ");
			String sportName = scSport.next();
//        	scSport.nextLine();
			System.out.println("Enter Teams Name: ");
			String TeamsName = scSport.next();
//        	scSport.nextLine();
			Sport sportEvent = new Sport(eventId, eventName, eventDate, eventTime, venueName, totalSeats, totalSeats,
					ticketPrice, eventType);
			sportEvent.setSportName(sportName);
			sportEvent.setTeamsName(TeamsName);
//            events.add(sportEvent);
			return sportEvent;

		default:
			throw new IllegalArgumentException("Invalid event type: " + eventType);
		}

	}

	public static void main(String[] args) {
		boolean flag = true;
		IEventServiceProvider service = new EventServiceProviderImpl();
		TicketBookingSystemDB clientservice = new TicketBookingSystemDB();
//		try {
			
		
		while (flag) {
			System.out.println("------------------------Welcome To Ticket Booking System------------------------");
			System.out.println("Please Choose the action to perform");
			System.out.println("1 for Creating Event");
			System.out.println("2 for Creating Venue");
			System.out.println("3 for Creating Customer");
			System.out.println("4 for Booking Tickets");
			System.out.println("5 for Cancelling Tickets");
			System.out.println("6 for Calculating Booking Cost");
			System.out.println("7 for Checking Tickets Available");
			System.out.println("8 for To View All Events");
			System.out.println("9 for Get Booking Details");
			System.out.println("10 for exit");

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
				System.out.println("Enter Venue ID: ");
				int venueName = scanner.nextInt();
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
				venueObj.setVenueId(venueName);
				;
				Event event = clientservice.createEvent(eventid, eventName, LocalDate.parse(eventDate),
						LocalTime.parse(eventTime), venueObj, totalSeats, ticketPrice, eventType);
				service.createEvent(event);
				System.out.println(" Event Created Successfully: " + event.getEventName());

				break;
			case 2:
				System.out.println("Please enter Venue ID:");
				int venueID = scanner.nextInt();
				System.out.println("Please enter Venue Name:");
				String cVenueName = scanner.next();
				System.out.println("Please enter Venue Address:");
				String venueAddress = scanner.next();

				Venue venue = new Venue(cVenueName, venueAddress, venueID);
				boolean venueFlag = service.createVenue(venue);
				if (venueFlag) {
					System.out.println("Venue Created Successfully: " + venue.getVenueName());
				}

				break;
			case 3:
				System.out.println("Please Enter CustomerID:");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please Enter your name:");
				String customerName = scanner.next();
				scanner.nextLine();
				System.out.println("Please Enter Your emai;:");
				String customerEmail = scanner.next();
				scanner.nextLine();
				System.out.println("Please Enter Your Phone Number:");
				String customerPhone = scanner.next();

				Customer customer = new Customer(customerName, customerEmail, customerPhone, customerId);
				boolean customerAddCheck = service.addCustomer(customer);
				if (customerAddCheck) {
					System.out.println("Customer added successfulyy");
				} else {
					System.err.println("Invalid Data for Customer");
				}
				break;
			case 4:
				System.out.println("Select Event ID for ticket Booking");
				List<Event> eventList = service.getEventDetails();
				for (Event e : eventList) {
					System.out.println(e.toString());
				}

				int selectedEventId = scanner.nextInt();
				Event selectedEvent = null;
				for (Event e : eventList) {
					if (e.getEventId() == selectedEventId) {
						selectedEvent = e;
						break;
					}
				}
					double ticketPriceCosting = 0.0;
					if(selectedEvent !=null) {
						 ticketPriceCosting = selectedEvent.getTicketPrice();
					}
					
					System.out.println("Enter Your Customer ID:");
					int customerIdBooking = scanner.nextInt();

					System.out.println("Enter No of Tickets:");
					int numOfTickets = scanner.nextInt();
					double totalPrice = ticketPriceCosting * numOfTickets;
					int bID = generateBookingID();
					com.hexaware.ticketbookingsystem.entity.Booking booking = new com.hexaware.ticketbookingsystem.entity.Booking(
							bID, customerIdBooking, selectedEventId, numOfTickets, totalPrice);
					boolean bookCheck = service.bookTicket(booking);
					if (bookCheck) {
						System.out.println("Booking Successfull: " + booking.getBookingId());
					} else {
						System.err.println("Booking Failed");
					}

				

				break;
			case 5:
				System.out.println("Please enter booking id to cancel ticket: ");
				int cancelID = scanner.nextInt();
				boolean cancelCheck = service.cancelTicket(cancelID);
				if (cancelCheck) {
					System.out.println("Booking cancelled successfully");
				} else {
					System.err.println("Booking cannot be cancelled");
				}
				break;
			case 6:
				System.out.println("Select Event ID for Calculating Cost");
				List<Event> eventPriceList = service.getEventDetails();
				for (Event e : eventPriceList) {
					System.out.println(e.toString());
				}

				int selectEventId = scanner.nextInt();
				Event selectEventIdP = null;
				String eventNameSelected = null;
				for (Event e : eventPriceList) {
					if (e.getEventId() == selectEventId) {
						selectEventIdP = e;
						eventNameSelected = e.getEventName();
						break;
					}
				}
				if (selectEventIdP != null) {
					System.out.println("Please enter the number of tickets");
					int numTicket = scanner.nextInt();
					double cost = service.calculateBookingCost(selectEventId, numTicket);
					System.out.println(
							"The cost of " + numTicket + " tickets of " + eventNameSelected + " will be: " + cost);
				} else {
					System.err.println("Invalid ID selected");
				}
				break;
			case 7:
				System.out.println("Select Event ID to see ticket's available");
				List<Event> ticketDetail = service.getEventDetails();
				for (Event e : ticketDetail) {
					System.out.println(e.getnameID());
				}
				int ticketCheckID = scanner.nextInt();
				Event selectTicket = null;
				for (Event e : ticketDetail) {
					if (e.getEventId() == ticketCheckID) {
						selectTicket = e;
						break;
					}
				}
				
				if(selectTicket != null) {
					service.getAvailableTickets(selectTicket);
				}else {
					System.err.println("Invalid ID Selected");
				}
				break;
			case 8:
				List<Event> eventDetail = service.getEventDetails();
				for (Event e : eventDetail) {
					System.out.println(e.toString());
				}
				break;
			case 9:
				System.out.println("Please Enter your Booking ID:");
				int bookId = scanner.nextInt();
				service.getBookingDetails(bookId);
				break;
			case 10:
				flag = false;
				System.out.println("Exiting Ticket Booking System");
				break;
			default:
				break;
			}
		}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.err.println("Please Enter valid input for specified columns");
//		}
		scanner.close();
	}
}
