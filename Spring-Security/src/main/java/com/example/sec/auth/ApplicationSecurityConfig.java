package com.example.sec.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http
		.authorizeRequests()
		.antMatchers("/public/**").permitAll()
		.anyRequest().fullyAuthenticated()
		.and()
		.httpBasic();

	}

}

