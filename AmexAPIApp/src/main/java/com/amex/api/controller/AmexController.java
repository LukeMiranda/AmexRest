package com.amex.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amex.api.model.Person;
import com.amex.api.service.PersonService;

@RestController
public class AmexController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/test")
	public String sayHi() {
		return "Hello";
	}
	
	@GetMapping("/People")
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping("/People/{email}")
	public Person getPersonByEmail(@PathVariable String email) {
		return personService.getPersonByEmail(email);
	}

	@GetMapping("/People/id/{id}")
	public Person getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
	}

	@PostMapping("/People")
	public void insertPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}

	@PutMapping("/People")
	public void updatePerson(@RequestBody Person person) {
		personService.updatePerson(person);
	}

	@DeleteMapping("/delete/email/{email}")
	@Transactional
	public void deletePersonByEmail(@PathVariable String email) {
		personService.deletePersonByEmail(email);
	}

	@DeleteMapping("/delete/id/{id}")
	@Transactional
	public void deletePersonById(@PathVariable int id) {
		personService.deletePersonById(id);
	}

	@GetMapping("/waldo")
	public ResponseEntity<Person> exceptionPerson() {
		return new ResponseEntity<Person>(HttpStatus.I_AM_A_TEAPOT);
	}
}
