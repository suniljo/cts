package com.cognizant.boot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties
//@PropertySource("dbconfig.properties")
//@PropertySource("classpath:dbconfig.properties")
@PropertySource(value = "classpath:dbconfig.properties")
@ConfigurationProperties(prefix = "jdbc")
public class DBConnection {
	// @Value("${driverClass}")
	private String driverClass;

	// @Value("${url}")
	private String url;

	// @Value("${usrName}")
	private String usrName;

	// @Value("${password}")
	private String password;

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBConnection [driverClass=" + driverClass + ", url=" + url + ", usrName=" + usrName + ", password="
				+ password + "]";
	}

}
