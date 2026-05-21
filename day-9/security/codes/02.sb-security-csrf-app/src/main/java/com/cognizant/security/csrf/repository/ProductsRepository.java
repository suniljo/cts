package com.cognizant.security.csrf.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.security.csrf.models.Product;

//@Repository
public class ProductsRepository {
	
	public static List<Product> getProducts(){		
		List<Product> productsList = new ArrayList<Product>(
					List.of(new Product(101, "Mobile"),
							new Product(102, "Computer"), 
							new Product(103, "Laptop") )
				);
		
		return productsList;
	}
}