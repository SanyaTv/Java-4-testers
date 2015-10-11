package com.example.tests;

import org.testng.annotations.Test;

public class EmptyContactCreation extends TestBase {
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    goToNewContactPage();
    fillNewContactForm(new ContactData("", "", "", "", "", "", "", "", "", "", "", "", "", ""));
    submitCreation();
    returnToHomePage();
  }
}
