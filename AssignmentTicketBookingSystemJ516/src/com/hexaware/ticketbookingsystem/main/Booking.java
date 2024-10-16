package com.hexaware.ticketbookingsystem.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.ticketbookingsystem.entity.Concert;
import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Movie;
import com.hexaware.ticketbookingsystem.entity.Sport;
import com.hexaware.ticketbookingsystem.entity.Venue;

//Task 4 implementation
public class Booking {
	private List<Event> event;

	public Booking() {
		super();
		Venue venueObj = new Venue();
		
		venueObj.setVenueName("Chennai, Tamil Nadu");
		
		event = new ArrayList<>();
		event.add(new Sport(1, "IPL Final", LocalDate.now().plusDays(20), LocalTime.of(18, 30),
				venueObj,
				20000, 20000, 5000, Event.EventType.SPORTS));
		event.add(new Concert(2, "India's Got Latent", LocalDate.now().plusDays(10), LocalTime.of(20, 30),
				venueObj, 500, 500, 1000, Event.EventType.CONCERT));
		event.add(new Movie(3, "Inception", LocalDate.now().plusDays(30), LocalTime.of(12, 30), venueObj,
				650, 650, 500, Event.EventType.MOVIE));
	}

	private void getEventDetails() {
		for (Event eventData : event) {
			System.out.println("Event ID:" + eventData.getEventId() + " Event Name: " + eventData.getEventName());
		}
	}

	private Event getEventById(int eventId) {
		for (Event eventRef : event) {
			if (eventRef.getEventId() == eventId) {
				return eventRef;
			}
		}
		return null;
	}

	private void calculateBookingCost(int eventId, int numOfTicket) {
		Event eventDetail = getEventById(eventId);

		System.out.println("The Ticket Price for " + numOfTicket + " " + eventDetail.getEventName()
				+ " Tickets will be : " + eventDetail.getTicketPrice() * numOfTicket);
	}
	
	private void bookTickets(int eventId,int numOfTicket) {
		Event eventDetail = getEventById(eventId);
		int availableSeats = eventDetail.getAvailableSeats();
		if(availableSeats>=numOfTicket) {
			eventDetail.bookTickets(numOfTicket);
		}else {
			System.out.println("Sorry only "+eventDetail.getAvailableSeats()+" tickets are remaining");
		}
	}
	
	private void cancelTicket(int eventId,int numOfTicket) {
		Event eventDetail = getEventById(eventId);
		eventDetail.cancelBooking(numOfTicket);
	}
	
	private void checkTicket(int eventId) {
		Event eventDetail = getEventById(eventId);
		System.out.println("The tickets available for "+eventDetail.getEventName()+" are : "+eventDetail.getAvailableSeats());
	}
	
	private void eventDetail(int eventId) {
		Event eventDetail = getEventById(eventId);
		System.out.println(eventDetail.toString());
		
	}

	public static void main(String[] args) {
		
			
		
		
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;

		Booking bookingSystem = new Booking();
		
		try {

		while (flag) {
			System.out.println(
					"----------------------------Welcome to Ticket Booking System:----------------------------");
			System.out.println(
					"1 Calculate Booking Cost\n2 Book Tickets\n3 Cancel Booking\n4 Check Available Tickets\n5 Check Event Details\n6 Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Choose the event Id to calculate Ticket Cost");
				bookingSystem.getEventDetails();
				int eventId = scanner.nextInt();
				System.out.println("Please Choose the num of ticket for booking");
				int numOfTicket = scanner.nextInt();
				bookingSystem.calculateBookingCost(eventId, numOfTicket);
				break;
			case 2:
				System.out.println("Choose the event Id to Book Event Tickets");
				bookingSystem.getEventDetails();
				int eventBookingId = scanner.nextInt();
				System.out.println("Please Choose the num of ticket for booking");
				int numOfTicketBooked = scanner.nextInt();
				bookingSystem.bookTickets(eventBookingId, numOfTicketBooked);
				break;
			case 3:
				System.out.println("Choose the event Id to Cancel Event Tickets");
				bookingSystem.getEventDetails();
				int eventCancelId = scanner.nextInt();
				System.out.println("Please Choose the num of ticket for cancelling");
				int numOfCancelledTicket = scanner.nextInt();
				bookingSystem.cancelTicket(eventCancelId, numOfCancelledTicket);
				break;
			case 4:
				System.out.println("Choose the event Id to Check Event's available Tickets");
				bookingSystem.getEventDetails();
				int checkChoice = scanner.nextInt();
				bookingSystem.checkTicket(checkChoice);
				break;
			case 5:
				System.out.println("Choose the event Id to Check Event's Detail");
				bookingSystem.getEventDetails();
				int detailId = scanner.nextInt();
				bookingSystem.eventDetail(detailId);
				break;
			case 6:
				System.out.println("Exiting Ticket Booking System");
				flag = false;
				break;
			default:
				System.err.println("Inavlid Option Selected");
				break;
			}

		}
		}catch (Exception e) {
			System.err.println("Please input valid values for specified columns");
		}
		scanner.close();
	}
}
