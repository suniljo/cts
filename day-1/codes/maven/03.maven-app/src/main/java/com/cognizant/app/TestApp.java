package com.cognizant.app;

import com.cognizant.utils.EncoderUtil;

public class TestApp {

	public static void main(String[] args) {
		EncoderUtil encoderUtilRef = new EncoderUtil();
		
		String pass = "password123#";
		String encodedPass = encoderUtilRef.encodeData(pass);
		
		System.out.println("encoded password = " + encodedPass);
	}

}
