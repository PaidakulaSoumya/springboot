package com.java.H2DatabaseSpringboot.repository;
import org.springframework.data.repository.CrudRepository; 
 import com.java.H2DatabaseSpringboot.model.Student;  
public interface StudentRepository extends CrudRepository<Student, Integer>  
{

}  