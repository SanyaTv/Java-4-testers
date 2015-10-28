package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//actions	
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
	    
	    // save new state
		List<ContactData> newList = app.getContactHelper().getContacts();    
	    
	    // compare states
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
