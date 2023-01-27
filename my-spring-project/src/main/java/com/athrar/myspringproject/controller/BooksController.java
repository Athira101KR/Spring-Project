package com.athrar.myspringproject.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athrar.myspringproject.model.book;
import com.athrar.myspringproject.service.bookService;

@RestController   //tells to spring that create an object and read this class as a Rest class
@RequestMapping("/books")	//Rest endpoint
public class BooksController {

	
	//@GetMapping		//whenever you send a get request to the endpoint "/books" this method will be invoked.
	//	public String testApplication()
	//	{
	//		return "Your application runs fine!";
	//		// or return "<html><body><h1> Your application runs fine! </h1></body></html>";
	//	}

	private static final Logger LOGGER=LogManager.getLogger(bookService.class);
	//performing CRUD operations
	
	
	@Autowired
	private bookService bookservice;
	
	//Retrieval
	@GetMapping
	public List<book> getAllBooks()
	{
		return this.bookservice.bookdb.values().stream().collect(Collectors.toList());
	}
	
	@GetMapping("/{bookid}")
	public ResponseEntity<?> getBookById(@PathVariable("bookid") Integer bookId)
	{
		book Book= this.bookservice.getBookByID(bookId);
		if(Book!=null)
		{
			return new ResponseEntity<>(Book,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(Book,HttpStatus.NOT_FOUND);
	}
	
	//create
	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody book newBookRequest )
	{
		//LOGGER.info(newBookRequest);
		book Book= this.bookservice.addNewBooktoDB(newBookRequest);
		if(Book!=null)
		{
			return new ResponseEntity<>(Book,HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>(Book,HttpStatus.BAD_REQUEST);
	}
	
	//update
	@PutMapping("/{bookid}")
	public ResponseEntity<?> updateBook(@PathVariable("bookid") Integer bookId,
							@RequestBody book updateBookRequest)
	{
		book Book= this.bookservice.updateBooktoDB(bookId,updateBookRequest);
		if(Book!=null)
		{
			return new ResponseEntity<>(Book,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(Book,HttpStatus.BAD_REQUEST);
	}
	
	//delete
	@DeleteMapping("/{bookid}")
	public ResponseEntity<?> deleteBook(@PathVariable("bookid") Integer bookId)
	{
		boolean status=  this.bookservice.deleteBookFromDB(bookId);
		if(status)
		{	
			LOGGER.info("Book with id "+bookId+" is deleted");
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		else {
			LOGGER.info("book with id "+bookId+" is not found");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
}
