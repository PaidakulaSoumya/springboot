package com.java.H2DatabaseSpringboot.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.H2DatabaseSpringboot.model.Account;
import com.java.H2DatabaseSpringboot.model.Student;
import com.java.H2DatabaseSpringboot.service.AccountService;
  
@RestController
public class AccountController { 
	@Autowired
	private AccountService accountService;

	@GetMapping("/account")
	public List<Account> getAllAccount() {  
		return accountService.getAllAccount();
	}

	@GetMapping("/student/{id}/account")
	public Student getAccount(@PathVariable("id") int id) {
		return accountService.getById(id);
	}

	@DeleteMapping("/student/{st_id}/account/{ac_id}")
	private void deleteAccount(@PathVariable("st_id") int stId, @PathVariable("ac_id") int acId) {
		accountService.deleteAccount(stId, acId);
	}

	@PostMapping("/student/{id}/account")
	private String saveAccount(@Valid @RequestBody Account account, @PathVariable int id) {
		accountService.create(account, id); 
		return "{" + "\n" + "id:" + account.getId() + "," + "\n" + "aadhar:" + account.getAadhar() + "," + "\n" + "}";
	}

	@PutMapping("/student/{id}/account")
	private String updateAccount(@Valid @RequestBody Account account, @PathVariable("id") int id) {
		accountService.update(account, id);
		return "{" + "\n" + "id:" + account.getId() + "," + "\n" + "aadhar:" + account.getAadhar() + "," + "\n" + "}";

	}
}
