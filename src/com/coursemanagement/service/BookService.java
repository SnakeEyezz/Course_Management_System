package com.coursemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coursemanagement.dao.BookDao;
import com.coursemanagement.dto.BookDTO;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	@Transactional
	public void addBook(BookDTO book) {
		
		bookDao.addBook(book);
	}

	@Transactional
	public void updateBook(BookDTO book) {
		
		bookDao.updateBook(book);
	}

	@Transactional
	public List<BookDTO> listBook() {
		
		return bookDao.listBook();
	}

	@Transactional
	public BookDTO getBookById(int bookId) {
		
		return bookDao.getBookById(bookId);
	}

	@Transactional
	public void removeBook(int bookId) {
		
		bookDao.removeBook(bookId);
	}

}