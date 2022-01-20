package com.torryharris.SpringJPADemo.service;

import java.util.List;

import com.torryharris.SpringJPADemo.model.Person;

public interface PersonService {
	void insertPerson(Person person);
	List<Person> getAllPerson();
	Person getPersonById(long aadhar);
}
