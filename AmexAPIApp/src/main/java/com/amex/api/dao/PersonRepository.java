package com.amex.api.dao;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.amex.api.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	public List<Person> findAll();
	//public Person findByEmail(String email);
	//public Person findOne(String personId);
//	public void delete(String Id);
//	public void deleteByEmail(String email);
}
