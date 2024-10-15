package com.hexaware.ticketbookingsystem.entity;

public class Customer {
	private String customerName;
	private String email;
	private String phoneNumber;
	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer() {
		super();
	}

	
	

	public Customer(String customerName, String email, String phoneNumber, int customerId) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public void displayCustomerDetails() {
		System.out.println("Customer [customerName=" + customerName + ", email=" + email + ", phoneNumber=" + phoneNumber + "]");
	}
	
}

