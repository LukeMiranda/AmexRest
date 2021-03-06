package com.amex.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amex.api.dao.PersonRepository;
import com.amex.api.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAllPeople(){
		List<Person> people = new ArrayList<>();
		personRepository.findAll().forEach(people::add);
		return people;
	}
	
	public void addPerson(Person p) {
		personRepository.save(p);
	}
	
	public Person getPersonById(int id) {
		return personRepository.getPersonByPersonId(id);
	}
	
	public Person getPersonByEmail(String email) {
		return personRepository.getPersonByEmail(email);
	}
	
	public void updatePerson(Person person) {
		personRepository.save(person);
	}
	
	@Transactional
	public void deletePersonById(int id) {
		personRepository.deletePersonByPersonId(id);
	}
	
	@Transactional
	public void deletePersonByEmail(String email) {
		personRepository.deletePersonByEmail(email);
	}
}
