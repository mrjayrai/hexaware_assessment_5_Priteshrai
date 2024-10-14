package com.hexaware.ticketbookingsystem.main;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hexaware.ticketbookingsystem.entity.Event;
import com.hexaware.ticketbookingsystem.entity.Venue;

public abstract class BookingSystem {
	public abstract Event createEvent(int eventId, String eventName, LocalDate eventDate, LocalTime eventTime,
            Venue venueName, int totalSeats, double ticketPrice, Event.EventType eventType);
}
