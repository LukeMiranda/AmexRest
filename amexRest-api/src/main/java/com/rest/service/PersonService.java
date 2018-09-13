package com.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.PersonRepository;
import com.rest.model.Person;

@Service
public class PersonService {
	
	List<Person> persons = Arrays.asList(
			new Person("a@gmail.com", "Letter A", "000-000-0001", "Alphabet", "Antartica"),
			new Person("b@gmail.com", "Letter B", "000-000-0002", "Braille", "Bavaria"),
			new Person("c@gmail.com", "Letter C", "000-000-0003", "Color", "Canada")
	);
	
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
	
	public Person getPersonById(String id) {
		return personRepository.findOne(id);
	}
	
	public Person getPersonByEmail(String email) {
		return personRepository.findByEmail(email);
	}
	
	public void updatePerson(Person person) {
		personRepository.save(person);
	}
	
	public void deletePersonById(String id) {
		personRepository.delete(id);
	}
	
	public void deletePersonByEmail(String email) {
		personRepository.deleteByEmail(email);
	}
	
}
