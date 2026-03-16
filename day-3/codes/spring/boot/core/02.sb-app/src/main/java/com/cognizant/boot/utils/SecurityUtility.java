package com.cognizant.boot.utils;

import java.util.Base64;
import java.util.Base64.Encoder;

public class SecurityUtility {

	public SecurityUtility() {
		System.out.println("SecurityUtility :: Constructor");
	}
	
	public String encodeData(String data) {
		Encoder encoder = Base64.getEncoder();
		String encodedData = encoder.encodeToString(data.getBytes());
		return encodedData;
	}
	
	public void myInit() {
		System.out.println("user-defined initialization - post construct");
	}
	
	public void myDestroy() {
		System.out.println("user-defined destructor - pre destroy");
	}	
}
