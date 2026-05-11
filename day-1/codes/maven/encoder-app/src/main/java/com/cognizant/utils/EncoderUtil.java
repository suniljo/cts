package com.cognizant.utils;

import java.util.Base64;
import java.util.Base64.Encoder;

public class EncoderUtil {
	public String encodeData(String data) {
		Encoder encoder = Base64.getEncoder();
		byte[] dataBytes = data.getBytes();
		
		String encodedData = encoder.encodeToString(dataBytes);
		
		return encodedData;
	}
}
