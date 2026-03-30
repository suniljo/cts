package com.cognizant.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

		http.csrf(csrf -> csrf.disable());

		http.httpBasic(Customizer.withDefaults()); // configures HTTP Basic authentication.

		DefaultSecurityFilterChain filterChain = http.build();

		return filterChain;
	}
	
	@Bean
	public UserDetailsService generateUsers() { //UserDetailsService --> Core interface which loads user-specific data. 
		UserDetails user1 = User.withUsername("admin")
								.password("{noop}12345")								
								.roles("ADMIN")
								.build();
		
		var user2 = User.withUsername("sunil")
						.password("{noop}password123#")
						.roles("MANAGER")
						.build();
		
		System.out.println("****** ---> " + user1.getPassword());
		
		/*
		UserDetailsManager userDtlsMgr = new InMemoryUserDetailsManager();
		userDtlsMgr.createUser(user1);
		userDtlsMgr.createUser(user2);		
		return userDtlsMgr;
		*/
		
		UserDetailsService userDtlsService = new InMemoryUserDetailsManager(user1, user2);
		
		return userDtlsService;
	}		
}
