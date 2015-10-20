package com.example.fw;

import org.openqa.selenium.By;

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
		
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

}
