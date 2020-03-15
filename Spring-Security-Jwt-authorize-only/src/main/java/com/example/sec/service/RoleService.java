package com.example.sec.service;

import java.util.List;
import java.util.Optional;

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
	
	public Role getRoleById(Integer roleId) throws Exception {
		Optional<Role> role =repo.findById(roleId);
		if(role.isPresent()) {
			return role.get();
		}
		else {
			throw new Exception("Role not found");
		}

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
