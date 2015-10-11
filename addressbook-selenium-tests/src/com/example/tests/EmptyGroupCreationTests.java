package com.example.tests;

import org.testng.annotations.Test;

public class EmptyGroupCreationTests extends TestBase {
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupsPage();
    initGroupsCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitCreation();
    returnToGroupsPage();
  }
}
