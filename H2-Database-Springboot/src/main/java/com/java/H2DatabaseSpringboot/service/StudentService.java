package com.java.H2DatabaseSpringboot.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.java.H2DatabaseSpringboot.exception.ResourceNotFoundException;
import com.java.H2DatabaseSpringboot.model.Book;
import com.java.H2DatabaseSpringboot.model.Student;
import com.java.H2DatabaseSpringboot.repository.StudentRepository;

@Service
public class StudentService { 
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private FeignInterface feignInterface;
	/*
	 * getting all student records  
	 */
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		studentRepository.findAll().forEach(student -> students.add(student));
		return students;
	}
	/*
	 * getting a specific record  
	 */
	public Student getStudent(int id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

	/*
	 * deleting a specific record  
	 */
	public ResponseEntity<Student> deleteStudent(int id) {
		java.util.Optional<Student> student = this.studentRepository.findById(id);

		if (student.isPresent()) {
			this.studentRepository.delete(student.get());
		} else {
			throw new ResourceNotFoundException("User not found with id : " + id);
		}
		return null;

	}
	/*
	 * updating a specific record  
	 */
	public Student updateStudent(int id, Student student) {
		{
			Student existingStudent = studentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
			existingStudent.setId(student.getId());
			existingStudent.setName(student.getName());
			existingStudent.setEmail(student.getEmail());
			return studentRepository.save(existingStudent);
		}
	}
	/*
	 * saving a specific record  
	 */
	public Student create(Student student) {
		String value=feignInterface.getDetails();
		student.setFeign(value);
		return studentRepository.save(student);
		
	}
	public void createBookForStudent(List<Book> books,	int studentid) {
		Optional<Student> student = studentRepository.findById(studentid);
		if(student.isPresent()) {    
			Student student1 = student.get(); 
			student1.setBooks(books);
		   for (Book book : books) {
			book.setStudent(student1);
			
		}    
			studentRepository.save(student1);   
		}
} 
	
		
	} 

