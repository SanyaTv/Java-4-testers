package com.example.tests;

import org.testng.annotations.Test;

public class EmptyContactCreation extends TestBase {
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
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
  }
}
