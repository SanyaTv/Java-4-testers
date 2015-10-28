package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class EmptyContactCreation extends TestBase {
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "";
	contact.lastName = "";
	contact.address = "";
	contact.phoneHome = "";
	contact.phoneMobile = "";
	contact.phoneWork = "";
	contact.firstEmail = "";
	contact.secondEmail = "";
	contact.bDay = "-";
	contact.bMonth = "-";
	contact.bYear = "";
	contact.contactGroup = "[none]";
	contact.secondPhone = "";			
	contact.secondAddress = "";
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
   
    // save new state
	List<ContactData> newList = app.getContactHelper().getContacts();    
    
    // compare states
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    

  }
}
