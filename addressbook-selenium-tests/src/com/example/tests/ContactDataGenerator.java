package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
	  if (args.length < 3) {
		  System.out.println("Please specify parameters: <amout of test data> <file> <format>");
		  return;
	  }
	  
	  int amount = Integer.parseInt(args[0]);
	  File file = new File(args[1]);
	  String format = args[2];
	  
	  if (file.exists()) {
		  System.out.println("File exists, please remove it manually: " + file);
		  return; 
	  }
	  
	  List<ContactData> contacts = generateRandomContacts(amount);
	  if ("csv".equals(format)) {
		  saveContactsToCsvFile(contacts, file);
	  } else if ("xml".equals(format)) {
		  saveContactsToXmlFile(contacts, file);
	  } else {
		  System.out.println("Unknown format " + format);
		  return;
	  }
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + "," + contact.getPhoneHome() + "," + 
		contact.getPhoneMobile() + "," + contact.getPhoneWork() + "," + contact.getFirstEmail() + "," + contact.getSecondEmail() + "," + 
					contact.getbDay() + "," + contact.getbMonth() + "," + contact.getbYear() + "," + contact.getContactGroup() + "," + 
		contact.getSecondAddress() + "," + contact.getSecondPhone() + ",!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
					.withFirstName(part[0])
					.withLastName(part[1])
					.withAddress(part[2])
					.withPhoneHome(part[3])
					.withPhoneMobile(part[4])
					.withPhoneWork(part[5])
					.withFirstEmail(part[6])
					.withSecondEmail(part[7])
					.withBDay(part[8])
					.withBMonth(part[9])
					.withBYear(part[10])
					.withContactGroup(part[11])
					.withSecondAddress(part[12])
					.withSecondPhone(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
			for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withAddress(generateRandomString())
					.withPhoneHome(generateRandomString())
					.withPhoneMobile(generateRandomString())
					.withPhoneWork(generateRandomString())
					.withFirstEmail(generateRandomString())
					.withSecondEmail(generateRandomString())
					.withBDay("11")
					.withBMonth("May")
					.withBYear(generateRandomString())
					.withContactGroup("group name 1")
					.withSecondAddress(generateRandomString())
					.withSecondPhone(generateRandomString());
			list.add(contact);
		}
		return list;
	}

	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
}
