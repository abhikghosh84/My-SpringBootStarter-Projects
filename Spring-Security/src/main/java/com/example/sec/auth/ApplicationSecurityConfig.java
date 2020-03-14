package com.example.sec.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("derby").password(appPasswordEncoder().encode("test").toString()).roles("IT_ADMIN");
		auth.inMemoryAuthentication().withUser("tom").password(appPasswordEncoder().encode("test").toString()).roles("TRAINEE");
	}
	
	
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
	
	@Bean
	public PasswordEncoder appPasswordEncoder() {
		BCryptPasswordEncoder p = new BCryptPasswordEncoder(10);
		return p;
	}

}

