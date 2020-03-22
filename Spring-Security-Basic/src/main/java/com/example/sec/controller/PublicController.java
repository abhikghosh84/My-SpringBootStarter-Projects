package com.example.sec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api")
public class PublicController {
	@GetMapping
	public String sayGreeting() {
		return "Hello from Spring Starter Project";
	}
}
