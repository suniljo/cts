package com.cognizant.pms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pms.entities.Product;
import com.cognizant.pms.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	@Mock
	ProductRepository prodRepo;
	
	//@Mock
	@InjectMocks
	ProductService prodService;
	static Product prod = null;
	
	@BeforeAll
	public static void initBeforAllTests() {
		prod = new Product();
		prod.setId(1);
		prod.setName("Mobile");
		prod.setPrice(2500);
	}
	@Test
	void saveProductShouldSaveProductSuccessfully() {
		
		Mockito.when(prodRepo.save(prod)).thenReturn(prod);
	
		Product addedProduct = prodService.saveProduct(prod);
		System.out.println(addedProduct);
		
		assertNotNull(addedProduct);
        assertEquals(prod.getId(),addedProduct.getId());
        assertEquals(prod.getName(),addedProduct.getName());
        assertTrue(prod.getId()==1);

	}

}