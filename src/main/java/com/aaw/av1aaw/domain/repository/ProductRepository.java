package com.aaw.av1aaw.domain.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.aaw.av1aaw.domain.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	
}
