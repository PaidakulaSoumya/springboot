package com.java.H2DatabaseSpringboot.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.H2DatabaseSpringboot.model.Student;
import com.java.H2DatabaseSpringboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.java.H2DatabaseSpringboot.model.Book;

/*
 * creating RestController  
 */
@RestController
public class StudentController<Book> {
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	/*
	 * autowired the StudentService class
	 */
	@Autowired
	private StudentService studentService;

	/*
	 * creating a get mapping that retrieves all the students detail from the
	 * database
	 */
	@GetMapping("/student")
	public List<Student> getAllStudent() {
		logger.info("Get Method is accessed");
		return studentService.getAllStudent();
	}

	/*
	 * creating a get mapping that retrieves the detail of a specific student
	 */
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		logger.info("GetById Method is accessed");
		return studentService.getStudent(id);
	}

	/*
	 * creating a delete mapping that deletes a specific student
	 */
	@DeleteMapping("/student/{id}")
	private void deleteStudent(@PathVariable("id") int id) {
		logger.info("Delete Method is accessed");
		studentService.deleteStudent(id);
	}

	/*
	 * creating post mapping that post the student detail in the database
	 */
	@PostMapping("/student")
	private Student saveStudent(@Valid @RequestBody Student student) {

		logger.info("Post Method is accessed");
		return studentService.create(student);
	}

	/*
	 * creating put mapping that updates the student detail in the database
	 */
	@PutMapping("/student/{id}")
	public Student update(@Valid @RequestBody Student student, @PathVariable("id") int id) {
		studentService.updateStudent(id, student);
		logger.info("Put Method is accessed");
		return student;
	}


	@PostMapping("student/{studentid}/book")
	public ResponseEntity<List<Book>> createBookForStudent(@RequestBody List<com.java.H2DatabaseSpringboot.model.Book> books,
			@PathVariable("studentid") int stuid) {
		studentService.createBookForStudent(books, stuid);
		return new ResponseEntity<>(HttpStatus.CREATED);  
	} 
}