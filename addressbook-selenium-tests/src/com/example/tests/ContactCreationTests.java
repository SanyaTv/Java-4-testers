package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
	app.getContactHelper().createContact(contact);

	// save new state
	List<ContactData> newList = app.getContactHelper().getContacts();    
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(oldList, newList);
    
  	}
  
}
