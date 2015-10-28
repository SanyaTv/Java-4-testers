package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class NonEmptyGroupCreationTests extends TestBase {
	
	  @Test(dataProvider = "randomValidGroupGenerator")
	  public void testGroupCreationWithValidData(GroupData group) throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupsPage();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
	    app.getGroupHelper().initGroupsCreation();
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupsPage();
	    
	    // save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    
	    // compare states
	    assertEquals(newList.size(), oldList.size() + 1);
	    
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	    
	  }
}
