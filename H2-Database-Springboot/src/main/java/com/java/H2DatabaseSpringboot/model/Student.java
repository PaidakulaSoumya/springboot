package com.java.H2DatabaseSpringboot.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/*
 *mark class as an Entity 
 */
@Entity
/*
 * /defining class name as Table name
 */
@Table
@Getter
@Setter
public class Student {
	/*
	 * /mark id as primary key
	 */
	@Id
	@Column
	
	private int id;
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@NotNull
	@Size(min = 2, message = "name should have atleast 2 characters")
	@Column
	private String name;

	@NotNull
	@Size(min = 2, message = "email should have atleast 2 characters")
	@Column
	private String email;
	
	private String feign;

	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Book> books = new ArrayList<>();

	public Student(int id, @NotNull @Size(min = 2, message = "name should have atleast 2 characters") String name,
			@NotNull @Size(min = 2, message = "email should have atleast 2 characters") String email, Account account, List<Book> books)  {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.account = account;
	}

	public Student() {
	}

/*public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Book> getBooks() {
		return books;
	}*/

	public void addBook(Book books) {
		this.books.add(books);
	}

	public void removeBook(Book books) {
		this.books.remove(books);

}
/*
	public String getFeign() {
		return feign;
	}

	public void setFeign(String feign) {
		this.feign = feign;
	}*/
}
