package com.example.tests;

public class ContactData {
	
	public String firstName;
	public String lastName;
	public String address;
	public String phoneHome;
	public String phoneMobile;
	public String phoneWork;
	public String firstEmail;
	public String secondEmail;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String contactGroup;
	public String secondAddress;
	public String secondPhone;

	public ContactData() {

	}
	public ContactData(String firstName, String lastName, String address, String phoneHome, String phoneMobile,
			String phoneWork, String firstEmail, String secondEmail, String bDay, String bMonth, String bYear,
			String contactGroup, String secondAddress, String secondPhone) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneHome = phoneHome;
		this.phoneMobile = phoneMobile;
		this.phoneWork = phoneWork;
		this.firstEmail = firstEmail;
		this.secondEmail = secondEmail;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.contactGroup = contactGroup;
		this.secondAddress = secondAddress;
		this.secondPhone = secondPhone;
	}



}