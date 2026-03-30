package com.cognizant.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> request.requestMatchers("/register/user")
													 .permitAll()
													 .anyRequest()
													 .authenticated());

		http.csrf(csrf -> csrf.disable());

		http.httpBasic(Customizer.withDefaults()); // configures HTTP Basic authentication.

		SecurityFilterChain filterChain = http.build();

		return filterChain;
	}
	

}
