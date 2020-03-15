package com.example.sec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sec.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
