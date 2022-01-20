package com.torryharris.SpringJPADemo.repository;

import java.util.List;

import com.torryharris.SpringJPADemo.model.Person;

public interface PersonDAO {
	void insertPerson(Person person);
	
	List<Person> getAllPerson();
	Person gtPersonById(long aadhar);
}
