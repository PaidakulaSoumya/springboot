package com.java.H2DatabaseSpringboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Account {
	@Id
	@Column
	private int id;
	@NotNull
	@Size(min = 2, message = "aadhar should have atleast 2 characters")
	@Column 
	private String aadhar;
	
	@OneToOne(mappedBy=  "account")
    private Student student;
	 public Account(int id, String aadhar) {
			this.id = id;
			this.aadhar = aadhar;
 }
	 public Account() { 
		}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
}

	




