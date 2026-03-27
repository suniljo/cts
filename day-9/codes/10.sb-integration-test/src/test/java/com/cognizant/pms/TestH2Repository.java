package com.cognizant.pms;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.pms.entities.Product;

public interface TestH2Repository extends JpaRepository<Product,Integer> {
}
