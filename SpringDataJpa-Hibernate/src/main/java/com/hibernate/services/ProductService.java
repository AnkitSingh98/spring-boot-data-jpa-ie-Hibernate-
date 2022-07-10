package com.hibernate.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hibernate.entitiy.Product;
import com.hibernate.repository.ProductRepository;



@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository  productRepository;
	 
	 
	
	// Create  ********
	public Product createProduct(Product product) {
		
		Product p =   productRepository.save(product);
		return p;
	}
	
	
	
	// Update  **********
	public Product updateProduct(Product newP, int pid) {
		
		Product p =   productRepository.findById(pid).get();
		p.setProductName(newP.getProductName());
		p.setProductDesc(newP.getProductDesc());
		p.setProductPrice(newP.getProductPrice());
		p.setStock(newP.isStock());
		
		Product updatedProd = productRepository.save(p);
		return updatedProd;
	}
	
	
	
	
	// Delete by id ***********
	public void deleteProduct(int pid) {
		
		Product p = productRepository.findById(pid).get();
		productRepository.delete(p);
	}
	
	
	// Delete All ***********
	public void deleteAll() {
		
	 productRepository.deleteAll();
	}
	
	
	
	// Get single Product  **********
	public Product getProduct(int pid) {
		
		Product p =  productRepository.findById(pid).get();
		return p;
	}
	
	
	
	// Get all Product  **********
	public List<Product> getAllProducts(){
		
		
		List<Product> list = productRepository.findAll();
		return list;
		
	}

}
