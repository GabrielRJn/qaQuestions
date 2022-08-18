package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
private String firstName;
private String lastName;
private int age;
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
}
