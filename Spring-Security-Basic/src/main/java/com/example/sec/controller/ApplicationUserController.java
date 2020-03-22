package com.example.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sec.model.ApplicationUser;
import com.example.sec.service.ApplicationUserService;

//@RestController
//@RequestMapping("/secured/user")
public class ApplicationUserController {
	
	@Autowired
	ApplicationUserService service;
	
	@GetMapping
	public List<ApplicationUser> getAllUsers() {
		return service.getAllUsers();
	}

	@PostMapping
	public String addUser(@RequestBody ApplicationUser user) {
		return service.addUser(user);
	}
	
	@PutMapping
	public String updateUser(@RequestBody ApplicationUser user) {
		return service.updateUser(user);
	}
	
}
