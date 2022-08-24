package com.example.demo.controller;



	
	import java.util.List;

	import javax.websocket.server.PathParam;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

	import com.example.demo.dto.booksDTO;
	import com.example.demo.model.Books;
	import com.example.demo.services.BooksDTOService;

	
	@RestController
	public class DTOController {
		
		@Autowired
		private BooksDTOService service;

	    public DTOController(BooksDTOService service) {
	        super();
	        this.service = service;
	    }

	    @PostMapping("/createDTO")
	    public booksDTO addBook(@RequestBody Books books1) {
	        return this.service.addBook(books1);
	    }

	    @GetMapping("/getAllDTO")
	    public List<Books> getAllBooks() {
	        return this.service.getAllBooks();
	    }

	    @PutMapping("/updateDTO")
	    public booksDTO updatePerson(@PathParam("id") long id, @RequestBody Books books1) {
	        return this.service.updateBook(id, books1);
	    }

	    @DeleteMapping("/deleteDTO/{id}")
	    public boolean removePerson(@PathVariable long id) {
	        return this.service.removeBook(id);
	    }

	    @GetMapping("/test")
	    public String test() {
	        return "Hello, World!";
	    }
}
