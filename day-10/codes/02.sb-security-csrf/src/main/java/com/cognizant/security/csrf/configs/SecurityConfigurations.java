package com.cognizant.security.csrf.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {

	@Bean
	public SecurityFilterChain customSecurityConfiguration(HttpSecurity http) {
		System.out.println("inside security configurations");
		
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		
		http.csrf(csrf -> csrf.disable());
		
		http.httpBasic(Customizer.withDefaults()); // configures HTTP Basic authentication.
		
		SecurityFilterChain securityFilterChain = http.build();
		
		return securityFilterChain;
	}
}
