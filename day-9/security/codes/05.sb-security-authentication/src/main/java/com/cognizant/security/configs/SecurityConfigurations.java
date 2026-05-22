package com.cognizant.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {
    
	@Bean
	public SecurityFilterChain customSecurityConfigs(HttpSecurity httpSecurity) {
	
		httpSecurity.authorizeHttpRequests(httpRequest -> httpRequest.requestMatchers("/home","/contact").permitAll()										 
																	 .anyRequest().authenticated());

		httpSecurity.csrf(csrf -> csrf.disable());
		
		httpSecurity.httpBasic(Customizer.withDefaults()); // configures HTTP Basic authentication.
		httpSecurity.formLogin(Customizer.withDefaults());

		SecurityFilterChain filterChain = httpSecurity.build();
		
		return filterChain;
	}
}


