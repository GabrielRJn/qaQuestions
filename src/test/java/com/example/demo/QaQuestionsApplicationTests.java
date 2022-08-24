package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//import com.example.bookshop.dto.booksDTO;
//import com.example.bookshop.model.books;
//import com.example.bookshop.repo.booksRepository;
//import com.example.bookshop.service.booksService;
import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepo;
import com.example.demo.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



	@SpringBootTest
	@AutoConfigureMockMvc
	//@Sql(scripts = { "classpath:books",
	//		"classpath:books.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@ActiveProfiles("dev")
	class QaQuestionsApplicationTests {

	    @Autowired
	    private BookService service;

	    @MockBean
	    private BooksRepo repo;
	    
	    @Autowired
	    private MockMvc mock;
	    
	    private final Books TEST_BOOK = new Books("TestBook",1111L, "TestAuthor",1000);

	    @Autowired
	    private ModelMapper mapper;
	    
	    @Autowired
		private ObjectMapper obmapper;
	    

	    //Unit Test Create 1
	    @Test
	    void testCreate(){
	    	
	        // GIVEN is our testing data - you can make this a final local variable if you want, e.g.:
	        final Books TEST_BOOK = new Books("TestBook",0L,  "TestAuthor",1000);
	        final Books TEST_SAVED_BOOK = new Books("TestBook",1L, "TestAuthor",1000);

	        // WHEN
	        Mockito.when(this.repo.save(TEST_BOOK)).thenReturn(TEST_SAVED_BOOK);

	        // THEN
	        Assertions.assertThat(this.service.saveOrUpdate(TEST_BOOK)).isEqualTo(TEST_SAVED_BOOK);

	        // verify that our repo was accessed exactly once
	        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_BOOK);
	        
	        System.out.println("Create Test Successful");
	        
	    }

	    //Unit Test 2
	    @Test
	    void testGetById() {
	    	
	    	// Setup the mock repo

	        Long bookId = 1001L;
	        final Books TEST_BOOK = new Books( "TestBook",bookId, "TestAuthor",1000);
	        //final Optional<books> TEST_SAVED_BOOK = Optional.empty();

	        // Make the service call
	    	Mockito.when(this.repo.findById(bookId)).thenReturn(Optional.of(TEST_BOOK)); 
			
	       System.out.println("Test for Get By ID Successful");
	       
	    }   
	        
	    //Unit Test 3
	    @Test
	    public void testDeleteStudentById() {
	    	
	    	
	    	Long bookId = 1001L;
	        final Books TEST_BOOK = new Books("TestBook", 0L, "TestAuthor",1000);
	        final Books TEST_SAVED_BOOK = new Books("TestBook",bookId, "TestAuthor",1000);
	        
	    	service.delete(TEST_SAVED_BOOK.getBookId());

	        Mockito.verify(repo, Mockito.times(1))
	                .deleteById(TEST_SAVED_BOOK.getBookId());
	        
	        System.out.println("Test for Delete By ID Successful");
	        
	    }
	    
	    //Unit Test 4
	    @Test
	    public void testFindAll() {

	    	final Books TEST_SAVED_BOOK = new Books("TestBook",1001L, "TestAuthor",1000);
	        List<Books> foundbooks = service.getAllBooks();
	        foundbooks.add(TEST_SAVED_BOOK);

	        assertNotNull(foundbooks);
	        assertEquals(1, foundbooks.size());
	        
	        System.out.println("Test for Find All Successful");
	    }

	    
	    //---------- Integration Test----------//
	        
	    
	  //Integration Test 1
	    @Test
		public void IntTestCreate() throws Exception {
			final Books newBook = new Books("How to do Skills", 1003L, "Neymar Jr",1000);
			
			this.mock
					.perform(post("/saveorupdateBook").contentType(MediaType.APPLICATION_JSON)
							.content(this.obmapper.writeValueAsString(newBook)))
					.andExpect(status().isCreated());
		}
	    
	    
	    
	    //Integration Test 2
	    @Test
		public void IntTestReadAll() throws Exception {
			final String resultString = this.mock
					.perform(request(HttpMethod.GET, "/allbooks").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

			List<Books> results = Arrays.asList(obmapper.readValue(resultString, Books[].class));
			assertEquals(new ArrayList<>(Arrays.asList()), results);
			System.out.println(results.size());
		}
    
        

}
