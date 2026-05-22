package com.cognizant.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognizant.filters.JwtAuthenticationFilter;
import com.cognizant.services.JwtAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain customSecurityConfigurations(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
        		.authorizeHttpRequests(request -> request
        				.requestMatchers("/auth/login").permitAll()
        				.anyRequest()
        				.authenticated());
                
         http.exceptionHandling(ex -> ex.authenticationEntryPoint(point));
         
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }


}
