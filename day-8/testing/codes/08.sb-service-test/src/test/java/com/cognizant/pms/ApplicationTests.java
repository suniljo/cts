package com.cognizant.pms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.cognizant.pms.entities.Product;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {
	
    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";
    
    private static RestTemplate restTemplate;
    
    @Autowired
    private TestH2Repository h2Repository;
    
    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/products");
        System.out.println(baseUrl);
    }
    
    
    @Test
    public void testAddProduct() {
        Product product = new Product("Mouse", 2, 275);
        Product response = restTemplate.postForObject(baseUrl, product, Product.class);
        System.out.println(response);
        assertEquals("Mouse", response.getName());
        assertEquals(1, h2Repository.findAll().size());
    }

}
