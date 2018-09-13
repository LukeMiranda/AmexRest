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

@RestController
@RequestMapping("api/Person")
public class AmexController {

	@Autowired
	private PersonDao PersonDao;
	
	@GetMapping("")
	public List<Person> getAllPerson(){
		return PersonDao.findAll();
	}
	
	@GetMapping("/email/{email}")
	public Person getPersonByEmail(){
		return PersonDao.getByEmail(email);
	}
	
	@PostMapping("")
	public void insertPerson(@RequestBody Person person) {
		PersonDao.save(person);
	}
	
	@PutMapping("/update")
	public void updatePerson(@RequestBody Person person) {
		PersonDao.save(person);
	}
	
	@DeleteMapping("/delete/{email}")
	public void deletePerson(@PathVariable String email) {
		PersonDao.deleteByEmail(email);
	}
	
	@GetMapping("/waldo")
	public ResponseEntity<Person> exceptionPerson(){
		return new ResponseEntity<Person>(HttpStatus.I_AM_A_TEAPOT);
	}
}
