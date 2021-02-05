package com.dev.nginx.grpc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PersonResource {

	@Autowired
	private PersonService personService;

	@GetMapping("/sayHello")
	public String ping() {
		log.info("Into the Person resource");
		return personService.sayHello();
	}

}
