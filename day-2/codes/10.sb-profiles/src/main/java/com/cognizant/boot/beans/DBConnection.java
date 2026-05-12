package com.cognizant.boot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jdbc")
public class DBConnection {
	private String driverClassName;
	private String url;
	private String usrName;
	private String password;

	public void setDriverClassName(String driverClass) {
		this.driverClassName = driverClass;
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
		return "DBConnection [driverClass=" + driverClassName + ", url=" + url + ", usrName=" + usrName + ", password="
				+ password + "]";
	}

}
