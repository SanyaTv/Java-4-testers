package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	static ApplicationManager app;
	
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.firstName = generateRandomString();
			contact.lastName = generateRandomString();
			contact.address = generateRandomString();
			contact.phoneHome = generateRandomString();
			contact.phoneMobile = generateRandomString();
			contact.phoneWork = generateRandomString();
			contact.firstEmail = generateRandomString();
			contact.secondEmail = generateRandomString();
			contact.bDay = "11";
			contact.bMonth = "May";
			contact.bYear = generateRandomString();
			contact.contactGroup = "group name 1";
			contact.secondAddress = generateRandomString();
			contact.secondPhone = generateRandomString();		
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "BINGO";
		} else {
			return "test" + rnd.nextInt();
		}
	}
  

}
