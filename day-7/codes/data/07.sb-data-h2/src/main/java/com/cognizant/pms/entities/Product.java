package com.cognizant.pms.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRODUCT_MASTER")
@Data
public class Product {
	@Id
	//@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_gen")
	//@SequenceGenerator(name = "pid_gen", sequenceName = "product_seq", initialValue = 1001, allocationSize = 1)	
	private Integer productId;
	private String productName;
	private Float productPrice;

	public Product(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
}
