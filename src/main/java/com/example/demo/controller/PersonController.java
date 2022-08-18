package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.model.Person;
import com.example.demo.services.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/peoplehome")
	public String home() {
		return "Lets look at what people are in the db";
	}
	
	@GetMapping("/people")
	public List<Person> getPeople() {
		return personService.getAllPeople();
	}
	
	@GetMapping("/people/{pid}")
	public List<Person> getAllPeople(@PathVariable ("pid") long personid) {
		return personService.getAllPeople();
	}
	
	@PostMapping("/post")
	public void postPerson(@RequestBody Person person) {
		 personService.saveOrUpdatePerson(person);
	}
	
	
	
	
	
}
