package com.example.demo.services;


	import java.util.ArrayList;
import java.util.List;


	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
	import com.example.demo.repository.BooksRepo;

	@Service
	public class BookService {

		
		@Autowired  
		BooksRepo booksRepository;  
		//getting all books record by using the method findaAll() of CrudRepository  
		public List<Books> getAllBooks()   
		{  
		List<Books> books1 = new ArrayList<Books>();  
		booksRepository.findAll().forEach(books2 -> books1.add(books2));  
		return books1;
		
		}  
		//getting a specific record by using the method findById() of CrudRepository  
		public Books getBooksById(long id)   
		{  
		return booksRepository.findById(id).get();
		}  
		//saving a specific record by using the method save() of CrudRepository  
		public void saveOrUpdate(Books books1)   
		{  
		booksRepository.save(books1);  
		}  
		//deleting a specific record by using the method deleteById() of CrudRepository  
		public void delete(long id)   
		{  
		booksRepository.deleteById(id);  
		}  
		//updating a record  
		public void update(Books books1, long bookid)   
		{  
		booksRepository.save(books1);  
		}  
		
		
	}


