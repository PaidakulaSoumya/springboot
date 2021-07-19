package com.java.H2DatabaseSpringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.H2DatabaseSpringboot.model.Book;  
public interface BookRepository extends CrudRepository<Book, Integer>  
{

}  





