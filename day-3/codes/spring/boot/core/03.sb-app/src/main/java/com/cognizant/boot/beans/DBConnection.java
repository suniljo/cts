package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties
//@PropertySource("dbconfig.properties")
//@PropertySource("classpath:dbconfig.properties")
@PropertySource(value = "classpath:dbconfig.properties")
//@PropertySource(value = "dbconfig.properties")
@ConfigurationProperties(prefix="jdbc")
public class DBConnection {
	//@Value("${driverClassName}")
	private String driverClassName;
	
	//@Value("${url}")
	private String url;
	
	//@Value("${usrName}")
	private String usrName;
	
	//@Value("${password}")
	private String password;

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
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
		return "DBConnection [driverClassName=" + driverClassName + ", url=" + url + ", userName=" + usrName
				+ ", password=" + password + "]";
	}
}
