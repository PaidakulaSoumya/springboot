package com.java.H2DatabaseSpringboot.controller;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static com.java.H2DatabaseSpringboot.controller.controllerJunitJsonFormat.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import com.java.H2DatabaseSpringboot.model.Student;
import com.java.H2DatabaseSpringboot.repository.StudentRepository;
import com.java.H2DatabaseSpringboot.service.StudentService;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {


	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private StudentService studentService;
    @MockBean
	private StudentRepository studentRepository; 
   
	
	
	@Test
	@DisplayName("test for getbyid method")
	public void testGetStudent() throws Exception {
		Student student = new Student();
		  student.setId(1);
		  student.setName("soumya");
		  student.setEmail("analin@gmail.com");
		 String getRequestBody = getJsonFormat(student);
		Mockito.when(studentService.getStudent(student.getId())).thenReturn(student);
        RequestBuilder requestBuilder = get("/student/1").accept(MediaType.APPLICATION_JSON);
		mockmvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(getRequestBody));
        verify(studentService, atLeast(1)).getStudent(student.getId());
		
	}

	@Test
	@DisplayName("test for post method")
	public void testCreateStudent() throws Exception {
		Student student = new Student(1, "soumya", "soumya@gmail.com", null,null);
		Mockito.when(studentService.create(any())).thenReturn(student);
        String postRequestBody = getJsonFormat(student);
		RequestBuilder requestBuilder = post("/student").characterEncoding("UTF-8")
				.contentType(MediaType.APPLICATION_JSON).content(postRequestBody);
		mockmvc.perform(requestBuilder).andExpect(status().isOk());
		verify(studentService, times(1)).create(any()); 
	}
   
	@Test
	@DisplayName("test for update method")
	public void testUpdateStudent() throws Exception {
		Student student = new Student(3, "soumya", "soumya@gmail.com", null, null);
		student.setId(3);
		student.setName("soumya");
		student.setEmail("soumya@gmail.com");
		Mockito.when(studentService.updateStudent(anyInt(), any())).thenReturn(student);
		String putRequestMethod = getJsonFormat(student);
		RequestBuilder requestBuilder = put("/student/3").characterEncoding("UTF-8")
				.contentType(MediaType.APPLICATION_JSON).content(putRequestMethod);
		mockmvc.perform(requestBuilder).andExpect(status().isOk());
		verify(studentService, times(1)).updateStudent(anyInt(),any());
	}
}
