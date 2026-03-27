package com.cognizant.pms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pms.entities.Product;

@Repository
public interface TestH2Repository extends JpaRepository<Product,Integer> {
}

