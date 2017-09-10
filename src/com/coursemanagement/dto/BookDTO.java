package com.coursemanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_DTO")
public class BookDTO {
	
	@Id
	@GeneratedValue
	@Column(name = "BOOK_ID")
	private int bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "PRICE")
	private float price;
	@Column(name ="QUANTITY")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	CourseDTO course;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = course;
	}

}