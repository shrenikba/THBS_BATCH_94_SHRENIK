package com.torryharris.SpringJPADemo;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.torryharris.SpringJPADemo.config.PersonJPAConfig;
import com.torryharris.SpringJPADemo.model.Person;
import com.torryharris.SpringJPADemo.service.PersonService;

public class PersonJPADemo {
	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(PersonJPAConfig.class);
		PersonService personservice = context.getBean(PersonService.class);
		
		Person p1 = new Person(123344444L, "Ram", "Ayodha", 1234566L);
		Person p2 = new Person(123344443L, "Sham", "madhubani", 2234566L);
		Person p3 = new Person(123344442L, "Aamn", "Jhansi", 3234566L);
		Person p4 = new Person(123344441L, "Raman", "Jalna", 4234566L);
		
		ArrayList<Person> pl = new ArrayList<Person>();
		pl.add(p1);
		pl.add(p2);
		pl.add(p3);
		pl.add(p4);
		
		
		for(Person p:pl) {
			personservice.insertPerson(p);
			System.out.println(p);
		}
		System.out.println("All Person data Inserted");
		
		System.out.println("Person dat from the DB....");
		for(Person person:personservice.getAllPerson()) {
			System.out.println(person);
		}
		System.out.println("\nSearching ..................");
		Person personFindById = personservice.getPersonById(123344441L);
		System.out.println(personFindById);
	}   
	
}
