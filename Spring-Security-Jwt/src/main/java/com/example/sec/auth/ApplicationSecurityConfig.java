package com.example.sec.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.sec.model.ApplicationUser;
import com.example.sec.model.Role;
import com.example.sec.repository.ApplicationUserRepository;
import com.example.sec.repository.RoleRepository;
import com.example.sec.service.ApplicationUserService;
import com.example.sec.service.RoleService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ApplicationUserDetailsService service;
	
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(appPasswordEncoder());
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.headers().frameOptions().disable();

		 http
         .csrf().disable();
		 
         http
         .authorizeRequests()
         .antMatchers("/h2-console/**").permitAll()
         .antMatchers("/public/**").permitAll()
         .anyRequest().authenticated()
         .and()
         .httpBasic();

	}
	
	@Bean
	public PasswordEncoder appPasswordEncoder() {
		BCryptPasswordEncoder p = new BCryptPasswordEncoder(10);
		return p;
	}
	
	
	@Autowired
	private ApplicationUserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Bean
	public void initDB() {
		
		Role role = new Role();
		ApplicationUser user = new ApplicationUser();
		role.setRole("IT_ADMIN");
		roleRepo.save(role);
		user.setUsername("derby");
		user.setPassword(appPasswordEncoder().encode("password"));
		user.setActive("Y");
		user.setRole(role);
		userRepo.save(user);
		
		Role role1 = new Role();
		ApplicationUser user1 = new ApplicationUser();
		role1.setRole("TRAINEE");
		role1 = roleRepo.save(role1);
		user1.setUsername("tom");
		user1.setPassword(appPasswordEncoder().encode("password"));
		user1.setActive("Y");
		user1.setRole(role1);
		userRepo.save(user1);
		
		
		
	}

}

