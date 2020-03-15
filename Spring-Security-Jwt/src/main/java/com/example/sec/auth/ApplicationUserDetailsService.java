package com.example.sec.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sec.model.ApplicationUser;
import com.example.sec.service.ApplicationUserService;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
	ApplicationUserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails customeUserDetails = null;

			try {
				ApplicationUser user = service.getUserByUserName(username);
				
				System.out.println(user);
				
				customeUserDetails = new CustomUserDetails();
				
				customeUserDetails.setUser(user);
				
				System.out.println(customeUserDetails);
			} catch (Exception e) {
				e.printStackTrace();
			}

		
		return customeUserDetails;
	}

}
