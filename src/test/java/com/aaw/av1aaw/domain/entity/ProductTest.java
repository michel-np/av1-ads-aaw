package com.aaw.av1aaw.domain.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.aaw.av1aaw.api.ProductDTO;

import com.aaw.av1aaw.domain.enums.Status;


public class ProductTest {

	@Test
	void test_create_new_product_with_valid_dto() {
		ProductDTO dto = new ProductDTO();
		dto.setNome("iPhone");
		dto.setDescricao("iPhone 13 Pro Max 1TB");
		dto.setStatus(Status.DISPONIVEL);
		dto.setUrlFoto("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-13-blue-select-2021?wid=470&hei=556&fmt=jpeg&qlt=95&.v=1629842712000");
		dto.setValor(20000.0f);
		
		var result = new Product(dto);
		
		assertEquals(dto.getNome(), result.getNome());
		assertEquals(dto.getDescricao(), result.getDescricao());
		assertEquals(dto.getStatus(), result.getStatus());
		assertEquals(dto.getUrlFoto(), result.getUrlFoto());
		assertEquals(dto.getValor(), result.getValor());
		
		
	}
}
