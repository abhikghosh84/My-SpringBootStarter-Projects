package com.example.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sec.model.ApplicationUser;
import com.example.sec.repository.ApplicationUserRepository;

@Service
public class ApplicationUserService {
	
	@Autowired
	private ApplicationUserRepository repo;
	
	public List<ApplicationUser> getAllUsers(){
		return repo.findAll();
	}
	
	public Object getUserById(Integer userId) {
		return repo.findById(userId).orElse(new IllegalAccessException("User Not Found"));
	}
	
	public String addUser(ApplicationUser user) {
		repo.save(user);
		return "User Added: "+user.getUser_id();
	}
	
	public String updateUser(ApplicationUser user) {
		repo.save(user);
		return "User Updated: "+user.getUser_id();
	}

}
