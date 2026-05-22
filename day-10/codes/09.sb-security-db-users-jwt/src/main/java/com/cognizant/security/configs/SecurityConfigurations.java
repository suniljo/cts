package com.cognizant.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognizant.security.filters.JwtFilter;

@Configuration
public class SecurityConfigurations {
    @Autowired
    private JwtFilter jwtFilter;
    
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> request.requestMatchers("/auth/**")
													 .permitAll()
													 .anyRequest()
													 .authenticated());

		http.csrf(csrf -> csrf.disable());

		http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		SecurityFilterChain filterChain = http.build();

		return filterChain;
	}
	

}
