package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Books {
	@Column
	private String bookName;
	@Column
	private String author;
	@Column
	private int price;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long bookId; 
	

}
