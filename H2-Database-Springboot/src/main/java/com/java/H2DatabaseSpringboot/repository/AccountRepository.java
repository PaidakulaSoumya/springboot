package com.java.H2DatabaseSpringboot.repository;
import org.springframework.data.repository.CrudRepository;

import com.java.H2DatabaseSpringboot.model.Account;  
public interface AccountRepository extends CrudRepository<Account, Integer>  
{

}  




