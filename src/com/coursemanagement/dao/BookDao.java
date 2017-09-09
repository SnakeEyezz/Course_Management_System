package com.coursemanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coursemanagement.dto.BookDTO;

@Repository
public class BookDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addBook(BookDTO book) {
		
		sessionFactory.getCurrentSession().save(book);
	}

	public void updateBook(BookDTO book) {
		
		sessionFactory.getCurrentSession().update(book);
	}

	@SuppressWarnings("unchecked")
	public List<BookDTO> listBook() {
		
		return sessionFactory.getCurrentSession().createQuery("from BookDTO").list();
	}

	@SuppressWarnings("unchecked")
	public BookDTO getBookById(int bookId) {
		
		Session session = sessionFactory.getCurrentSession();
		List<BookDTO> list = session.createQuery("from Book b where b.id= :bookId")
								 .setParameter("bookId", bookId).list();
		return  list.size()>0 ? (BookDTO)list.get(0): null;
	}

	public void removeBook(int bookId) {
		
		BookDTO book = (BookDTO) sessionFactory.getCurrentSession().load(BookDTO.class, bookId);
		sessionFactory.getCurrentSession().delete(book);
	}

}
