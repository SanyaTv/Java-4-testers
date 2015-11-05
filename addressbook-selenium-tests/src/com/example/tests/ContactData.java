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
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	public ContactData withPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
		return this;
	}
	public ContactData withPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
		return this;
	}
	public ContactData withPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
		return this;
	}
	public ContactData withFirstEmail(String firstEmail) {
		this.firstEmail = firstEmail;
		return this;
	}
	public ContactData withSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
		return this;
	}
	public ContactData withBDay(String bDay) {
		this.bDay = bDay;
		return this;
	}
	public ContactData withBMonth(String bMonth) {
		this.bMonth = bMonth;
		return this;
	}
	public ContactData withBYear(String bYear) {
		this.bYear = bYear;
		return this;
	}
	public ContactData withContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
		return this;
	}
	public ContactData withSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
		return this;
	}
	public ContactData withSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public String getPhoneWork() {
		return phoneWork;
	}
	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	public String getFirstEmail() {
		return firstEmail;
	}
	public void setFirstEmail(String firstEmail) {
		this.firstEmail = firstEmail;
	}
	public String getSecondEmail() {
		return secondEmail;
	}
	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}
	public String getbDay() {
		return bDay;
	}
	public void setbDay(String bDay) {
		this.bDay = bDay;
	}
	public String getbMonth() {
		return bMonth;
	}
	public void setbMonth(String bMonth) {
		this.bMonth = bMonth;
	}
	public String getbYear() {
		return bYear;
	}
	public void setbYear(String bYear) {
		this.bYear = bYear;
	}
	public String getContactGroup() {
		return contactGroup;
	}
	public void setContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
	}
	public String getSecondAddress() {
		return secondAddress;
	}
	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}
	public String getSecondPhone() {
		return secondPhone;
	}
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}	
}