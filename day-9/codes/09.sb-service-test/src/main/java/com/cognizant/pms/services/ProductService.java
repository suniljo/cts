package com.cognizant.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pms.entities.Product;
import com.cognizant.pms.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;
    
    @Autowired
    public ProductService(ProductRepository repository) {
		super();
		this.repository = repository;
	}

	public Product saveProduct(Product product) { 
		if(product.getName() != null && product.getName().length()==0)
			 throw new RuntimeException("Invalid Name Of Product");
		
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(int productId,Product product) {
        Product existingProduct = repository.findById(productId).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}

