package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.services.BookService;


@RestController
public class BookController {

	//auto-wire the BookService class  
		@Autowired  
		BookService bookService;  
		
		@GetMapping("/")
		public String greeting() { 
			return "Welcome Student. Please go to \"/allBooks\" for all available Books";
			}
		
		//creating a get mapping that retrieves all the Books detail from the database   
		@GetMapping("/allBooks")  
		private List<Books> getAllBooks()   
		{  
		return bookService.getAllBooks();
		}
		//creating a get mapping that retrieves the detail of a specific book  
		@GetMapping("/book/{bookid}")  
		private Books getBooks(@PathVariable("bookid") long bookid)   
		{  
		return bookService.getBooksById(bookid) ; 
		}  
		//creating a delete mapping that deletes a specified book  
		@DeleteMapping("/book/{bookid}")  
		private void deleteBook(@PathVariable("bookid") long bookid)   
		{  
		bookService.delete(bookid);
		}  
		
		//creating post mapping that post the book detail in the database  
		@PostMapping("/postBooks")  
		private Long saveBook(@RequestBody Books books1)   
		{  
		bookService.saveOrUpdate(books1);
		return books1.getBookId();  
		}   
		//creating put mapping that updates the book detail   
		@PutMapping("/putBooks")  
		private Books update(@RequestBody Books Books1)   
		{  
		bookService.saveOrUpdate(Books1);  
		return Books1;  
		}  
}
