package com.example.sec.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.sec.model.ApplicationUser;
import com.example.sec.model.Role;
import com.example.sec.repository.ApplicationUserRepository;
import com.example.sec.repository.RoleRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        	.antMatchers("/authenticate").permitAll()
        	.antMatchers("/h2-console/**").permitAll()
        	.anyRequest().authenticated()
            .and().exceptionHandling()
            .and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        
        http.headers().frameOptions().disable();
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
		//user.setPassword(passwordEncoder().encode("password"));
		user.setPassword("password");
		user.setActive("Y");
		user.setRole(role);
		userRepo.save(user);
		
		Role role1 = new Role();
		ApplicationUser user1 = new ApplicationUser();
		role1.setRole("TRAINEE");
		role1 = roleRepo.save(role1);
		user1.setUsername("tom");
		//user1.setPassword(passwordEncoder().encode("password"));
		user1.setPassword("password");
		user1.setActive("Y");
		user1.setRole(role1);
		userRepo.save(user1);
		
		
		
	}
}
