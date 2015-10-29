package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
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
	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		//result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public int compareTo(ContactData other) {
		//return (this.lastName.toLowerCase() + this.firstName.toLowerCase()).compareTo (other.lastName.toLowerCase() + other.firstName.toLowerCase());
		int res =  lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (res != 0) {
		  return res;
		}
		return firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
		}	
}