package com.aaw.av1aw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

import com.aaw.av1aaw.api.ProductDTO;
import com.aaw.av1aaw.domain.entity.Product;
import  com.aaw.av1aaw.service.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class ProductController {
	private final ProductService productService;
	
	
	@GetMapping("/products")
	public List<ProductDTO> getAll() {
		var products = productService.getAll();
		
		var productDtos = new ArrayList<ProductDTO>();
		
		for (var product: products) {
			productDtos.add(new ProductDTO(product));
		}
		return productDtos;
	}
	
	@GetMapping("/products/{id}")
	public ProductDTO getById(@PathVariable String id) {
		var product = productService.get(id);
		
		return new ProductDTO(product);
	}
	
	@PostMapping("/products")
	public ProductDTO create(@RequestBody ProductDTO productDto) {
		var product = new Product(productDto);
		
		product = productService.create(product);
		return new ProductDTO(product);
	}
	
	@PutMapping("/products/{id}")
	public ProductDTO update(@PathVariable String id, @RequestBody ProductDTO productDto) {
		var product = new Product(productDto);
		product = productService.update(id, product);
		
		return new ProductDTO(product);
	}
	
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		productService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
