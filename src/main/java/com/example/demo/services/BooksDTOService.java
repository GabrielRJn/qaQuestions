package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.booksDTO;
import com.example.demo.repository.BooksRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

import com.example.demo.model.Books;

@Service  
@AllArgsConstructor
public class BooksDTOService {
	//wiring the repo 
		@Autowired  
		private BooksRepo repo;
		
		
		
		
		
		    
		//DTO Service
		private booksDTO mapToDTO(Books books1) {
	        booksDTO dto = new booksDTO();
	        dto.setPrice(books1.getPrice());
	        dto.setBookId(books1.getBookId());
	        dto.setBookName(books1.getBookName());
	        return dto;
	    }

		public booksDTO addBook(Books books1) {
	        Books saved =  this.repo.save(books1);
	        return this.mapToDTO(saved);
	    }

		public List<Books> getAllBooks()   
		{  
		List<Books> books1 = new ArrayList<Books>();  
		repo.findAll().forEach(books2 -> books1.add(books2));  
		return books1;  
		} 

	    public booksDTO updateBook(long id, Books books1) {
	        Optional<Books> existingOptional = this.repo.findById(id);
	        Books existing = existingOptional.get();

	        existing.setPrice(books1.getPrice());
	        existing.setBookName(books1.getBookName());

	        Books updated =  this.repo.save(existing);
	        return this.mapToDTO(updated);
	    }

	    public boolean removeBook(long id) {
	        this.repo.deleteById(id);
	        boolean exists = this.repo.existsById(id);
	        return !exists;
	    }

		
}
