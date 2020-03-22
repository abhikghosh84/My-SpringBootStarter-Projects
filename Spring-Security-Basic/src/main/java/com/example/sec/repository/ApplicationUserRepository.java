package com.example.sec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sec.model.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer>{

	Optional<ApplicationUser> findByUsernameIgnoreCase(String userName);

}
