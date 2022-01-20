package com.torryharris.SpringJPADemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.torryharris.SpringJPADemo.model.Person;


@Repository
public class PersonDAOImpl implements PersonDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public void insertPerson(Person person) {
		entityManager.persist(person);
	}

	public List<Person> getAllPerson() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> cq = builder.createQuery(Person.class);
		Root<Person> root = cq.from(Person.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Person gtPersonById(long aadhar) {
		// TODO Auto-generated method stub
		return null;
	}

}
