package com.example.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sec.model.Role;
import com.example.sec.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repo;
	
	public List<Role> getAllRoles(){
		return repo.findAll();
	}
	
	public Object getRoleById(Integer roleId) {
		return repo.findById(roleId).orElse( new IllegalAccessException("Role Not Found"));
	}
	
	public String addRole(Role role) {
		repo.save(role);
		return "Role Added: "+role.getRole_id();
	}
	
	public String updateRole(Role role) {
		repo.save(role);
		return "Role Updated: "+role.getRole_id();
	}

}
