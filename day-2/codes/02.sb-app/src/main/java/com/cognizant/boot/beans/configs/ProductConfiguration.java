package com.cognizant.boot.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.cognizant.boot.utils.SecurityUtility;

@Configuration
public class ProductConfiguration {

	public ProductConfiguration() {
		System.out.println("ProductConfiguration :: Constructor");
	}
	
	//@Bean
	//@Bean("security")
	//@Bean(value = "security")
	//@Bean(name = "security")
	//@Bean(value = {"security", "encoder"})
	@Bean(value = {"security", "encoder"}, initMethod = "myInit", destroyMethod = "myDestroy")
	@Scope("singleton")
	//@Scope(value = "prototype")
	@Lazy
	public SecurityUtility generateSecurityUtility() {
		return new SecurityUtility();
	}
}
