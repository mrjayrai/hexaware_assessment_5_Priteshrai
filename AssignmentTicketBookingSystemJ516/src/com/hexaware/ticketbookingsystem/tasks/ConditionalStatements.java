package com.hexaware.ticketbookingsystem.tasks;

import java.util.Scanner;

// Task 1 Implementation
public class ConditionalStatements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Total Number of Tickets:\n");
		int totalTickets = scanner.nextInt();
		System.out.println("Enter the Number of Tickets to be Booked:\n ");
		int numOfBookTicket = scanner.nextInt();
		if (numOfBookTicket <= totalTickets) {
			System.out.println("Ticket's are availabale, you can proceed with bookings");
		} else {
			System.out.println("Sorry only " + totalTickets + " tickets are left");
		}
		scanner.close();

	}
}
