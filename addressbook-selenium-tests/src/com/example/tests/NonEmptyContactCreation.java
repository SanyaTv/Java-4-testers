package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class NonEmptyContactCreation extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "John";
	contact.lastName = "Doe";
	contact.address = "Kingston13";
	contact.phoneHome = "111111";
	contact.phoneMobile = "222222";
	contact.phoneWork = "333333";
	contact.firstEmail = "4test@test.ee";
	contact.secondEmail = "3test@test.ee";
	contact.bDay = "21";
	contact.bMonth = "January";
	contact.bYear = "1989";
	contact.contactGroup = "group name 1";
	contact.secondPhone = "666666";			
	contact.secondAddress = "Kingston666";
    app.getContactHelper().fillNewContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    // save new state
	List<ContactData> newList = app.getContactHelper().getContacts();    
    
    // compare states
    assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
  
}
