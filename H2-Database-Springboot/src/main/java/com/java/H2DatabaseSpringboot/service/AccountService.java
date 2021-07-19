package com.java.H2DatabaseSpringboot.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.H2DatabaseSpringboot.exception.ResourceNotFoundException;
import com.java.H2DatabaseSpringboot.model.Account;
import com.java.H2DatabaseSpringboot.model.Student;
import com.java.H2DatabaseSpringboot.repository.AccountRepository;
import com.java.H2DatabaseSpringboot.repository.StudentRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
 
	@Autowired
	private StudentRepository studentRepository;

	public List<Account> getAllAccount() {
		List<Account> accounts = new ArrayList<Account>();
		accountRepository.findAll().forEach(account -> accounts.add(account));
		return accounts;
	}

	public Student getById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			Student s = student.get();
			return s;
		} else {
			throw new ResourceNotFoundException("User not found with id : " + id);

		}

	}

	public Student create(Account account, int id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			Student s = student.get();
			s.setAccount(account);
			return studentRepository.save(s);
		} else {
			throw new ResourceNotFoundException("User not found with id : " + id);


		}

	}

	public Student update(Account account, int id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			Student s = student.get();
			s.setAccount(account);
			return studentRepository.save(s);
		} else {
			throw new ResourceNotFoundException("User not found with id : " + id);

		}
	}


	public void deleteAccount(int studentId, int accountId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if (student.isPresent()) {
			Optional<Account> account = accountRepository.findById(accountId);
			if (account.isPresent()) {
				accountRepository.delete(account.get());
				Student s = student.get();
				s.setAccount(null);
				studentRepository.save(s);        
			}
		} else {
			throw new ResourceNotFoundException("User not found with id : " + accountId);


		}
	}
}
