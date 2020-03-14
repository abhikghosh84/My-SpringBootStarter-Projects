package com.example.sec.service;

import java.util.List;
import java.util.Optional;

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
	
	public ApplicationUser getUserById(Integer userId) throws Exception {
		Optional<ApplicationUser> user =  repo.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new Exception("User Not Found");
		}
	}
	
	public ApplicationUser getUserByUserName(String userName) throws Exception {
		Optional<ApplicationUser> user =  repo.findByUsernameIgnoreCase(userName);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new Exception("User Not Found");
		}
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
