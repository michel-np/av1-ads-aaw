package com.aaw.av1aaw.domain.entity;

import com.aaw.av1aaw.domain.enums.Status;

import org.springframework.data.annotation.Id;

import com.aaw.av1aaw.api.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	private String id;
	private String nome;
	private String descricao;
	private String urlFoto;
	private Float valor;
	private Status status;
	public Product (ProductDTO p){
		this.setId(p.getId());
		this.setNome(p.getNome());
		this.setDescricao(p.getDescricao());
		this.setUrlFoto(p.getUrlFoto());
		this.setValor(p.getValor());
		this.setStatus(p.getStatus());
	}
}
