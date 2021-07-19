package com.java.H2DatabaseSpringboot.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign",url = "localhost:3031/sem")
public interface FeignInterface {

	@GetMapping(path = "/ya",produces = "application/json")
	public String getDetails();
}
