package com.cognizant.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT_MASTER")
public class Product {
	@Id
	//@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.AUTO) 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_seq_generator")
	@SequenceGenerator(name = "pid_seq_generator", initialValue = 1001, allocationSize = 1, sequenceName = "product_id_generator")
	private Integer productId;
	private String productName;
	private Float productPrice;

	public Product(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
}
