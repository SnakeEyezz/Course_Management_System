package com.coursemanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanagement.dto.BookDTO;
import com.coursemanagement.service.BookService;

@RestController
public class BookController {
	
	@Autowired 
	private BookService bookService;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<BookDTO> getBookList(){
		
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		
		bookList.addAll(bookService.listBook());
		
		return bookList;
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<BookDTO> getBook(@PathVariable("id") int id){
		
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		
		bookList.add(bookService.getBookById(id));
		
		return bookList;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public boolean addBook(@RequestBody BookDTO book){
		
		bookService.addBook(book);
		
		return true;
	}
	
	@RequestMapping(value = "/books/{id}", method= RequestMethod.PUT)
	public boolean updateBook(@PathVariable("id") int id, @RequestBody BookDTO book){
		
		bookService.updateBook(book);
		
		return true;
	}
	
	@RequestMapping(value = "/books/{id}", method= RequestMethod.DELETE)
	public boolean removeBook(@PathVariable("id") int id){
		
		bookService.removeBook(id);
		
		return true;
	}

}