package com.cognizant.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.pms.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
