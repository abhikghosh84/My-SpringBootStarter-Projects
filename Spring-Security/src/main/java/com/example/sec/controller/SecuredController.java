package com.example.sec.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sec.model.Greeting;

@RestController
@RequestMapping("/secured/api")
public class SecuredController {
	@GetMapping
	@PreAuthorize(value = "hasAnyRole('IT_ADMIN', 'TRAINEE')")
	public String sayGreeting() {
		return "Hello from Spring Starter Project - Secured";
	}

	@PostMapping
	@PreAuthorize(value = "hasRole('IT_ADMIN')")
	public String addGreeting(@RequestBody Greeting greeting) {
		return greeting + " is added to the db!";
	}

	@PutMapping
	@PreAuthorize(value = "hasRole('IT_ADMIN')")
	public String updateGreeting(@RequestBody Greeting greeting) {
		return greeting + " is updated in the db!";
	}

	@DeleteMapping
	@PreAuthorize(value = "hasRole('IT_ADMIN')")
	public String deleteGreeting(@RequestParam Integer greetingId) {
		return greetingId + " is deleted from the db!";
	}
}
