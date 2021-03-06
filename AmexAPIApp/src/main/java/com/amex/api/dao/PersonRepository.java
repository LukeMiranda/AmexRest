package com.amex.api.dao;
import org.springframework.data.repository.CrudRepository;
import com.amex.api.model.Person;

public interface PersonRepository extends CrudRepository<Person, String>{
	public Person getPersonByEmail(String email);
	public Person getPersonByPersonId(int id);
	public void deletePersonByEmail(String email);
	public void deletePersonByPersonId(int id);
}
