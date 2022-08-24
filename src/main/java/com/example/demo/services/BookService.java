package com.example.demo.services;



import java.util.ArrayList;  
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.AllArgsConstructor;
import com.example.demo.exception.*;
import com.example.demo.controller.*;
import com.example.demo.dto.*; 
import com.example.demo.model.*;  
import com.example.demo.repository.*;



@Service  
@AllArgsConstructor
public class BookService {

		

		//wiring the repo 
		@Autowired  
		BooksRepo BooksRepo;  
		
		
		private ModelMapper mapper;
		
		//getting all Books record by using the method findAll() of CrudRepository  
		public List<Books> getAllBooks()   
		{  
		List<Books> Books1 = new ArrayList<Books>();  
		BooksRepo.findAll().forEach(Books2 -> Books1.add(Books2));
		return Books1;  
		}  
		
		//getting a specific record by using the method findById() of CrudRepository  
		public Optional<Books> getBookById(long id)   
		{  
			//Books found = this.BooksRepo.findById(id).orElseThrow(BookNotFoundID::new);
			return BooksRepo.findById(id);
		}  

		//saving a specific record by using the method save() of CrudRepository  
		public Books saveOrUpdate(Books Books1)   
		{  
		return BooksRepo.save(Books1);  
		}  
		
		//deleting a specific record by using the method deleteById() of CrudRepository  
		public void delete(long id)   
		{  
		BooksRepo.deleteById(id);
		} 
		
		//updating a record  
		public void update(Books Books1, int bookid)   
		{  
		BooksRepo.save(Books1);
		}  
		
	

		
		
	}


