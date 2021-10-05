package com.aaw.av1aaw.service;
import com.aaw.av1aaw.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import com.aaw.av1aaw.domain.entity.Product;
import com.aaw.av1aaw.exception.NotFoundException;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;
	
	public Product get(String id) {
		var product = productRepository.findById(id);
		
		if(product.isEmpty()) {
			throw new NotFoundException("Nothing found with ID: " + id+ ". Good luck next time.");
		}
		return product.get();
	}
	
	public List<Product> getAll() {
		return productRepository.findAll();
		
	}
	
	public Product create(Product p) {
		return productRepository.save(p);
	}
	
	public Product update(String id, Product p) {
		var existing = get(id);
		existing.setNome(p.getNome());
		existing.setDescricao(p.getDescricao());
		existing.setUrlFoto(p.getUrlFoto());
		existing.setValor(p.getValor());
		existing.setStatus(p.getStatus());
		
		productRepository.save(existing);
		
		return existing;
		
	}
	
	public void delete(String id) {
		get(id);
		productRepository.deleteById(id);
	}
	
}
