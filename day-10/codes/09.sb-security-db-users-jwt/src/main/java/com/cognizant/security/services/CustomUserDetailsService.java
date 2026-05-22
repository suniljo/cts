package com.cognizant.security.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		UserCredential userCredential =  credentialRepo.findByUsername(username)
											.orElseThrow(() -> new UsernameNotFoundException("User not found")); ;
				
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                					userCredential.getUsername(),
                					userCredential.getPassword(),
                					List.of(new SimpleGrantedAuthority(userCredential.getRole()))
        );
		
		 return userDetails;
	}
}
