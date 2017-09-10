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
	public void addBook(int courseId,BookDTO book) {
		
		bookDao.addBook(courseId, book);
	}

	@Transactional
	public void updateBook(int bookId, BookDTO book) {
		
		BookDTO book1 = bookDao.getBookById(bookId);
		book1.setBookName(book.getBookName());
		book1.setAuthor(book.getAuthor());
		book1.setPrice(book.getPrice());
		book1.setQuantity(book.getQuantity());
		book1.setCourse(book.getCourse());
		
		bookDao.updateBook(bookId, book1);
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