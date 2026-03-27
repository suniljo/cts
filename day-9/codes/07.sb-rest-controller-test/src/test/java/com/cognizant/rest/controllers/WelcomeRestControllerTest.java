package com.cognizant.rest.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.rest.services.WelcomeServices;

@WebMvcTest(value = WelcomeRestController.class) //loads only MVC components
class WelcomeRestControllerTest {
	
	/*
	 @MockBean / @MockitoBean is a Spring Boot annotation used in tests to add mock objects 
	 to the Spring ApplicationContext. 
	 It replaces any existing bean of the same type or adds a new one if none 
	 exists, allowing for partial mocking of components. 
	 */
	@MockitoBean // from spring boot 3.4.0  -- before that @MockBean - replaces WelcomeService with a Mockito mock (if any bean exists)
	private WelcomeServices welServices;

	@Autowired
	private MockMvc mockMvc; // simulates HTTP requests without starting a server; used to send a request to REST API
	
	@Test
	void testShowWelcomeMessage() throws Exception {
		// define mock object behaviour
		Mockito.when(welServices.generateWelcomeMessage()).thenReturn("Welcome to Cognizant");
		
		// prepare HTTP get request
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/v1/welcome");
		
		// send request
		ResultActions perform = mockMvc.perform(reqBuilder);

		// hold the response
		MvcResult mvcResult = perform.andReturn();

		// validate response
		MockHttpServletResponse response = mvcResult.getResponse();

		String responseText = response.getContentAsString();
		System.out.println(responseText);
		
		int status = response.getStatus();
		System.out.println(status);

		assertNotNull(responseText);
		assertEquals(200, status);	
		
		/*
		 mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/welcome"))
		  .andExpect(MockMvcResultMatchers.status().isOk());
		 */
	}
}
