package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
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
        
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.name("entry"));
        for ( int rowI = 0 ; rowI < rows.size() ; rowI++ ) {
              WebElement row = rows.get(rowI);
              List<WebElement> cells = row.findElements(By.tagName("td"));
              ContactData contact = new ContactData();
              contact.lastName = cells.get(1).getText();
              contact.firstName = cells.get(2).getText();
              cachedContacts.add(contact);                                                                
        }
  }

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
    	initContactCreation();
    	fillContactForm(contact);
    	submitContactCreation();
    	returnToHomePage();
    	rebuildCache();
		return this;
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		initEditContact(index);
		fillContactForm(contact);
		updateContactInfo();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	public ContactHelper deleteContact(int index) {
		initEditContact(index);
		submitContactDeletion();
		returnToHomePage();
		rebuildCache();
		return this;
	}
// ----------------------------------------------------------------------------------------------------------------------------	
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}


	public ContactHelper fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.getFirstName());    		   		
	    type(By.name("lastname"), contact.getLastName());    		
	    type(By.name("address"), contact.getAddress());    		
	    type(By.name("home"), contact.getPhoneHome());    		
	    type(By.name("mobile"), contact.getPhoneMobile());    		
	    type(By.name("work"), contact.getPhoneWork());    		
	    type(By.name("email"), contact.getFirstEmail());    		
	    type(By.name("email2"), contact.getSecondEmail());    		
	    selectByText(By.name("bday"), contact.getbDay());
	    selectByText(By.name("bmonth"), contact.getbMonth());
	    type(By.name("byear"), contact.getbYear());    		
	    //selectByText(By.name("new_group"), contact.contactGroup);
	    type(By.name("address2"), contact.getSecondAddress());    		
	    type(By.name("phone2"), contact.getSecondPhone());    		
		return this;	    
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initEditContact(int index) {
		//click(By.xpath("//td[" + (index+1) +"]/a/img"));
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + (index+1) +"]/td[7]/a/img"));
		return this;
	}
	
	public ContactHelper submitContactDeletion() {
		click(By.xpath("//form[2]/input[2]"));
		return this;
	}

	public ContactHelper updateContactInfo() {
		click(By.xpath("//input[11]"));
		return this;
	}
}
