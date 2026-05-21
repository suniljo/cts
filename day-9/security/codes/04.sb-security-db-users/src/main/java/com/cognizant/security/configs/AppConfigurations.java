package com.cognizant.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfigurations {
	
	@Bean
	public PasswordEncoder generatePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
