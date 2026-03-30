package com.cognizant.security.csrf.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.security.csrf.models.Product;
import com.cognizant.security.csrf.repository.ProductsRepository;

@RestController
@RequestMapping(path = "/api/pms")
//@CrossOrigin
@CrossOrigin(origins = "https://localhost:3000") //- Allow from specific origin
public class ProductsRestController {
	
	private List<Product> productsList = ProductsRepository.getProducts();

	@GetMapping
	public List<Product> getAllProducts(){  
		return productsList; 
	}
	
	@GetMapping("{pid}")
	public Product getProductByProductId(@PathVariable("pid") Integer pid) {
	   Product product = productsList.stream()
			   						 .filter(prod -> prod.productId().equals(pid))
			   						 .findFirst()
			   						 .orElse(null);
	   return product; 
	}	
	
	@PostMapping
	public void addNewProduct(@RequestBody Product product) {
	   productsList.add(product);	   
	}		
	
}
