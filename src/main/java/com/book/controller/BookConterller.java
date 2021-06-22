package com.book.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookConterller {

	@Autowired
	BookService bookservice;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
	
		Book bk=bookservice.addBook(book);
		
		
		//return new ResponseEntity(bk,HttpStatus.CREATED);
		return bk;
	}
	@GetMapping("/getAllBook")
	public ResponseEntity<List<Book>> getAllBook()
	{
		List<Book> books = bookservice.getAllBook();
		
		return new ResponseEntity<>(books,HttpStatus.FOUND);
	}
}
