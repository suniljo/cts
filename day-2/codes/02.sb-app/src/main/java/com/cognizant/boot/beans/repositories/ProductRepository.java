package com.cognizant.boot.beans.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

	public ProductRepository() {
		System.out.println("ProductRepository :: Constructor");
	}

}
