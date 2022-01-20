package com.torryharris.SpringJPADemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torryharris.SpringJPADemo.model.Person;
import com.torryharris.SpringJPADemo.repository.PersonDAO;

@Service
public class PersonServiceImpl  implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	
	public void insertPerson(Person person) {
		personDAO.insertPerson(person);
		/*
		 * System.out.println(); System.out.println();
		 */
 
	}

	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return personDAO.getAllPerson();
	}

	public Person getPersonById(long aadhar) {
		// TODO Auto-generated method stub
		return personDAO.getPersonById(aadhar);
	}

}
