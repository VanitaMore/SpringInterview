package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products") 
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}
	
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}
	
	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.productService.deleteProduct(id);
		return HttpStatus.OK;
	}
}
