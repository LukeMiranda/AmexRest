package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.model.Person;
import com.rest.service.PersonService;

@RestController
@RequestMapping("/api")
public class AmexController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/hello")
	public String sayHi() {
		return "Hey";
	}
	
	@GetMapping("/People")
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping("/People/{email}")
	public Person getPersonByEmail(@PathVariable String email) {
		return personService.getPersonByEmail(email);
	}

	@GetMapping("/People/{id}")
	public Person getPersonById(@PathVariable String id) {
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

	@DeleteMapping("/delete/{email}")
	public void deletePersonByEmail(@PathVariable String email) {
		personService.deletePersonByEmail(email);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePersonById(@PathVariable String id) {
		personService.deletePersonById(id);
	}

	@GetMapping("/waldo")
	public ResponseEntity<Person> exceptionPerson() {
		return new ResponseEntity<Person>(HttpStatus.I_AM_A_TEAPOT);
	}
}
