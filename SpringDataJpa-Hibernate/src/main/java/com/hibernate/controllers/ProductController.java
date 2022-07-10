package com.hibernate.controllers;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.entitiy.Product;
import com.hibernate.services.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	
	//  Create Product Handler
	@RequestMapping(value="/create-product",method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		System.out.println("*************** Inside Create Product *******");
		return productService.createProduct(product);
	}
	
	
	// Update Product Handler
	@RequestMapping(value="/update-product/{pid}",method= RequestMethod.POST)
	public Product updateProduct(@RequestBody Product p,@PathVariable int pid) {
		
		productService.updateProduct(p, pid);
		
		return p;
	}
	
	
	
	// Delete by ID Product Handler
	@RequestMapping(value="/delete-productById",method=RequestMethod.DELETE)
	public void deleteProduct(@RequestParam int pid) {
		
		productService.deleteProduct(pid);
	}
	
	
	// Delete All Product Handler
	@RequestMapping(value="/delete-product",method=RequestMethod.DELETE)
	public void deleteProduct() {
		productService.deleteAll();
	}
	
	
	//Get Single Product Handler
	@RequestMapping(value="/get-productById/{pid}",method=RequestMethod.GET)
	public Product getProduct( @PathVariable int pid) {
		Product p = productService.getProduct(pid);
		return p;
	}
	
	
	// Get all Product Handler
	@RequestMapping(value="/get-product",method=RequestMethod.GET)
	public List<Product> getProduct(){
		
		
		List<Product> allproduct = productService.getAllProducts();
		return allproduct;
		
		
	}

}
