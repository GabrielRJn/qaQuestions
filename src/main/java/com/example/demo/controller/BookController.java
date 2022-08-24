package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.example.demo.model.Books;  
import com.example.demo.services.BookService;  

//mark class as Controller  

@RestController 
public class BookController {

	//auto-wire the BookService class  
		@Autowired  
		BookService BookService;  
		
		@GetMapping("/")
		public String greeting() { return "Welcome to the Book Shop. Please go to \"/allBooks\" for all available Books";}
		
		//creating a get mapping that retrieves all the Books detail from the database   
		@GetMapping("/allBooks")  
		private List<Books> getAllBooks()   
		{  
		return BookService.getAllBooks();  
		}  
		
		//creating a get mapping that retrieves the detail of a specific book  
		@GetMapping("/books/{bookid}")  
		private Optional<Books> getBookById(@PathVariable("bookid") int bookid)   
		{  
		return BookService.getBookById(bookid);  
		}  
		
		//creating a delete mapping that deletes a specified book  
		@DeleteMapping("/deletebook/{bookid}")  
		private void deleteBook(@PathVariable("bookid") int bookid)   
		{  
		BookService.delete(bookid);  
		}  
		
		//creating post mapping that post the book detail in the database  
		@PostMapping("/saveorupdateBook")  
		private ResponseEntity<Books> saveBook(@RequestBody Books Books1)   
		{  
			return new ResponseEntity<>(this.BookService.saveOrUpdate(Books1), HttpStatus.CREATED);
		}  
		
		//creating put mapping that updates the book detail   
		@PutMapping("/saveBooks")  
		private Books update(@RequestBody Books Books1)   
		{  
		BookService.saveOrUpdate(Books1);  
		return Books1;  
		}  
		
		
	
}
