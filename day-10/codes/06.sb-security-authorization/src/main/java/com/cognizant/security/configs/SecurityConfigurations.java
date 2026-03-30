package com.cognizant.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {
	@Autowired
	private PasswordEncoder encoder;
	
	@Bean
	public UserDetailsService generateUsers(){
		UserDetails user1 =  User.withUsername("admin")
					 .password(encoder.encode("12345"))
					 .roles("ADMIN")
					 .build();
		
		UserDetails user2 =  User.builder()
					 .username("sunil")
					 //.password(encoder.encode("12345"))	
					 .password("12345")
					 .passwordEncoder(pass -> encoder.encode(pass))
					 .roles("MANAGER")
					 .build();	

		UserDetails user3 =  User.builder()
				 	 .username("sanjay")
				 	 .password(encoder.encode("12345"))	
				 	 .roles("CLERK")
				 	 .build();		
		
		UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2, user3);
	
		return users;			
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(request -> request.requestMatchers("/home","/care")
															.permitAll()
															.requestMatchers("/admin").hasRole("ADMIN")							
															//.requestMatchers("/admin/**").hasRole("ADMIN")
															.requestMatchers("/manager").hasAnyRole("ADMIN","MANAGER")					
															//.requestMatchers("/manager").hasAnyAuthority("ADMIN","MANAGER")
															.requestMatchers("/clerk").hasAnyRole("ADMIN","MANAGER","CLERK")				
															.anyRequest()											
															.authenticated())

			.csrf(csrf -> csrf.disable())

			.httpBasic(Customizer.withDefaults())

			.build();
	}	
}
