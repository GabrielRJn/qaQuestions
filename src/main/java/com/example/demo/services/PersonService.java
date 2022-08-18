package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	PersonRepo repository;

	
	public Person getPersonById(long id) {
		return repository.findById(id).get();
	}
	
	public List<Person> getAllPeople() {
		return repository.findAll();
	}
	
	public void saveOrUpdatePerson(Person person) {
		repository.save(person);
	}
	
	public void delete(long id)   
	{  
		repository.deleteById(id);  
	}  
	//updating a record  
	public void update(Person rewrittenPerson)   
	{  
		repository.save(rewrittenPerson);  
	}  
	
	
}
