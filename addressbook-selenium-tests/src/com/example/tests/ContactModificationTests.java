package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initEditContact();
	    ContactData contact = new ContactData();
	    contact.lastName = "Smith";
	    contact.firstName = "Agent";
	    contact.bDay = "31";
	    contact.bMonth = "February";
	    contact.bYear = "666";
		app.getContactHelper().fillNewContactForm(contact);
		app.getContactHelper().updateContactInfo();
	    app.getContactHelper().returnToHomePage();
	}
}
