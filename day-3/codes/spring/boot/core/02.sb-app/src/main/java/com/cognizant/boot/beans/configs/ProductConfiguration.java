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
	//@Bean("encoder")
	//@Bean(value ="encoder")
	//@Bean(value = {"security","encoder"})
	@Bean(value = {"security","encoder"}, initMethod = "myInit", destroyMethod = "myDestroy")
	@Scope("singleton")
	//@Scope(value = "prototype")
	@Lazy(value = true)
	public SecurityUtility getSecurityUtilityBean() {
		return new SecurityUtility();
	}
}
