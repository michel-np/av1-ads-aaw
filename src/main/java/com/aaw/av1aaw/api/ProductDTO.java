package com.aaw.av1aaw.api;
import com.aaw.av1aaw.domain.enums.Status;
import com.aaw.av1aaw.domain.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private String id;
	private String nome;
	private String descricao;
	private String urlFoto;
	private Float valor;
	private Status status;
	public ProductDTO(Product p) {
		this.setId(p.getId());
		this.setNome(p.getNome());
		this.setDescricao(p.getDescricao());
		this.setUrlFoto(p.getUrlFoto());
		this.setValor(p.getValor());
		this.setStatus(p.getStatus());
	}
}
