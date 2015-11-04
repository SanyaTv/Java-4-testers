package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}


	public void initContactCreation() {
		click(By.linkText("add new"));
	}


	public void fillNewContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);    		   		
	    type(By.name("lastname"), contact.lastName);    		
	    type(By.name("address"), contact.address);    		
	    type(By.name("home"), contact.phoneHome);    		
	    type(By.name("mobile"), contact.phoneMobile);    		
	    type(By.name("work"), contact.phoneWork);    		
	    type(By.name("email"), contact.firstEmail);    		
	    type(By.name("email2"), contact.secondEmail);    		
	    selectByText(By.name("bday"), contact.bDay);
	    selectByText(By.name("bmonth"), contact.bMonth);
	    type(By.name("byear"), contact.bYear);    		
	    //selectByText(By.name("new_group"), contact.contactGroup);
	    type(By.name("address2"), contact.secondAddress);    		
	    type(By.name("phone2"), contact.secondPhone);    		
	    
	}

	public void submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initEditContact(int index) {
		//click(By.xpath("//td[" + (index+1) +"]/a/img"));
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + (index+1) +"]/td[7]/a/img"));
	}
	
	public void deleteContact() {
		click(By.xpath("//form[2]/input[2]"));
		cachedContacts = null;
	}


	public void updateContactInfo() {
		click(By.xpath("//input[11]"));
		cachedContacts = null;
	}

	
	private List<ContactData> cachedContacts;
	

	public List<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	
	}


	public void rebuildCache() {
		cachedContacts = new ArrayList<ContactData>();
        
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for ( int rowI = 1 ; rowI < rows.size() ; rowI++ ) {
              WebElement row = rows.get(rowI);
              List<WebElement> cells = row.findElements(By.tagName("td"));
              ContactData contact = new ContactData();
              contact.lastName = cells.get(1).getText();
              contact.firstName = cells.get(2).getText();
              cachedContacts.add(contact);                                                                
        }
     }

}
