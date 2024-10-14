package com.hexaware.ticketbookingsystem.tasks;

import java.util.Scanner;

// Task 2 Implementation 
public class NestedConditionalStatement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Total Number of Tickets:\n");
		int totalTickets = scanner.nextInt();
		System.out.println("Enter The Number of Tickets for Booking:\n");
		int numOfTickets = scanner.nextInt();
		System.out.println("Choose Category:\n1 for Diamond \n2 for Gold \n3 for Silver");
		int chooseCategory = scanner.nextInt();

		if (numOfTickets <= totalTickets) {
			switch (chooseCategory) {
			case 1:
				System.out.println("The Price of Tickets under Diamond Category: " + numOfTickets * 100);
				break;
			case 2:
				System.out.println("The Price of Tickets under Gold Category: " + numOfTickets * 80);
				break;
			case 3:
				System.out.println("The Price of Tickets under Silver Category: " + numOfTickets * 50);
				break;
			default:
				System.out.println("Invalid Category Choosen");
			}
		} else {
			System.out.println("Sorry only " + totalTickets + " tickets are left");
		}

		scanner.close();

	}
}
