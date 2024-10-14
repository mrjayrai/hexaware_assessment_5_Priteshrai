package com.hexaware.ticketbookingsystem.tasks;

import java.util.Scanner;

// Task 3 Completed
public class Looping {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Total Number of Tickets");
		int totalTickets = scanner.nextInt();
		boolean flag = true;
		while (flag) {
			if(totalTickets<=0) {
				System.out.println("No Tickets Available Now");
				flag = false;
				break;
			}
			System.out.println("Welcome to Ticket Booking System\n");
			System.out.println("1 for Ticket Booking\n2 for exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the number of tickets for booking:\n");
				int numOfTickets = scanner.nextInt();
				if(numOfTickets<=totalTickets) {
					System.out.println("Choose Category:\n1 for Diamond \n2 for Gold \n3 for Silver");
					int chooseCategory = scanner.nextInt();
					switch (chooseCategory) {
					case 1:
						System.out.println("The Price of Tickets under Diamond Category: " + numOfTickets * 100);
						totalTickets -= numOfTickets;
						break;
					case 2:
						System.out.println("The Price of Tickets under Gold Category: " + numOfTickets * 80);
						totalTickets -= numOfTickets;
						break;
					case 3:
						System.out.println("The Price of Tickets under Silver Category: " + numOfTickets * 50);
						totalTickets -= numOfTickets;
						break;
					default:
						System.out.println("Invalid Category Choosen");
					}
				}else {
					System.out.println("Sorry only " + totalTickets + " tickets are left");
				}
				break;
			case 2:
				flag = false;
				break;
			default:
				System.out.println("Invalid Option Choosen");
				break;
			}
		}

		scanner.close();
	}

}
