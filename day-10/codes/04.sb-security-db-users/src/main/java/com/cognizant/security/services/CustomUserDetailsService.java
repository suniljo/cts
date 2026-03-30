package com.cognizant.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.security.entities.UserCredential;
import com.cognizant.security.repositories.UserCredentialRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserCredentialRepository credentialRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCredential> optUserCredentail = credentialRepo.findByUsername(username);
		
		if(optUserCredentail.isPresent()) {
			UserCredential userCredential = optUserCredentail.get();
			
			String uname = userCredential.getUsername();
			String pass = userCredential.getPassword();
			
			UserDetails userDetails = User.builder()
										  .username(uname)
										  .password(pass)
										  .build();
			
			return userDetails;
		}
		throw new UsernameNotFoundException(username);
	}

}
