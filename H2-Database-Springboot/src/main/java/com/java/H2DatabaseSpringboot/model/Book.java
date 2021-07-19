package com.java.H2DatabaseSpringboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book")

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "Book_name")
	private String bookName;

	 

	@JsonIgnore
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "stu_id")
	private Student student;

	public Book() {

	}

	public Book(int bookId, String bookName, Student student) {
		this.bookId = bookId;
		this.bookName = bookName;
		
		this.student = student;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	

	public int getBookId() {
		return bookId;
	}
    public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}


