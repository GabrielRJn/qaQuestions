package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Person;



public interface PersonRepo extends JpaRepository<Person, Long> {

}