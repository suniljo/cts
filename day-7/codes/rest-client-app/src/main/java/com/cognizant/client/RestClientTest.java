package com.cognizant.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientTest {

	public static void main(String[] args) {
		RestTemplate restTemp = new RestTemplate();
		
		ResponseEntity<String> response = restTemp.getForEntity("http://localhost:8080/api/welcome", String.class);

		String responseData = response.getBody();
		
		System.out.println(responseData);
	}

}
