package com.aaw.av1aaw.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.aaw.av1aaw.domain.entity.Product;

import com.aaw.av1aaw.domain.repository.ProductRepository;
import com.aaw.av1aaw.exception.NotFoundException;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository productRepository;
	
	private ProductService unit;
	
	
	@BeforeEach
	public void setup() {
		unit = new ProductService(productRepository);
	}
	
	@Test
	void test_getByUd_withProduct_shouldReturnObj() {
		
		var product = new Product();
		String productId = "product1";
		product.setId(productId);
		
		
		Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(product));
		
		
		var result = unit.get(productId);
		
		
		Mockito.verify(productRepository).findById(productId);
	}
	
	
	@Test
	void test_getById_withNoEmployee_shouldThrowException() {
		String productId = "product1";
		
		Mockito.when(productRepository.findById(productId)).thenReturn(Optional.empty());
		
		try {
			unit.get(productId);
			fail("Expected NotFoundException");
		} catch (NotFoundException e) {
			Assertions.assertEquals(e.getMessage(),"Nothing found with ID: " + productId+ ". Good luck next time.");
		}
		
		Mockito.verify(productRepository).findById(productId);
	}

}
