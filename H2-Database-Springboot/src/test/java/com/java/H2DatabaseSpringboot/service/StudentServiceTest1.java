package com.java.H2DatabaseSpringboot.service;
import static org.junit.jupiter.api.Assertions.*; import static
org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
static org.mockito.Mockito.when;

import java.util.Optional; import java.util.stream.Collectors; import
java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks; import org.mockito.Mock; import
org.mockito.MockitoAnnotations; import
org.springframework.boot.test.context.SpringBootTest; import
org.springframework.http.ResponseEntity;

import com.java.H2DatabaseSpringboot.model.Student; import
com.java.H2DatabaseSpringboot.repository.StudentRepository;

@SpringBootTest class StudentServiceTest1 {
	  
	  @InjectMocks private StudentService studentService;
	  
	  @Mock private StudentRepository studentRepository;
	  
	  
	  @BeforeEach void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this); }

	  @Test void testGetAllStudent() { 
		  when(studentRepository.findAll()).thenReturn(Stream.of(new
		  Student(1,"meghana","meghana@gmail.com",null,null),new
		  Student(13,"pooja","pooja@gmail.com",null,null)) .collect(Collectors.toList()));
		  assertEquals(2,studentService.getAllStudent().size()); 

	
	}

	  @Test public void testGetStudent() { Student student = new Student();
	  student.setId(1); student.setName("meghana"); student.setEmail("meghana@gmail.com");
	 when(studentRepository.findById(student.getId())).thenReturn(Optional.of(
	  student)); Student student1 = studentService.getStudent(1);
	  assertEquals("meghana",student1.getName()); 

	}

	  @Test public void testDeleteStudent() { Student student = new Student();
	  student.setId(3);
	  when(studentRepository.findById(student.getId())).thenReturn(Optional.of(
	  student)); ResponseEntity<Student> s1 = studentService.deleteStudent(3);
	  verify(studentRepository,times(1)).delete(student); 
	  
}
	  @Test
		public void testsaveStudent() {
		Student student = new Student();
		student.setId(2);
		student.setName("sony");
		student.setEmail("sony@gmail.com");
		when(studentRepository.save(student)).thenReturn(student);
		Student student1 = studentService.create(student);
		assertEquals(student1.getId(), student.getId());
		assertEquals(student1.getName(), student.getName());
		assertEquals(student1.getEmail(), student.getEmail());
		}

		}	

