package com.example.demo.dto;


import java.util.ArrayList;  
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;  
import com.example.demo.controller.*;
import com.example.demo.dto.*;
import com.example.demo.model.Books;  
import com.example.demo.repository.BooksRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.config.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class booksDTO   
{  
	
	
	
		@Column
		private String bookName;
		
		
		
		
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long bookId; 
		
		//Defining book id as primary key  
		
		
		@Column  
		private String author;  
		@Column  
		private int price;  
}  
