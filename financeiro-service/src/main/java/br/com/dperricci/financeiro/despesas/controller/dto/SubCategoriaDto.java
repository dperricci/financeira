package br.com.dperricci.financeiro.despesas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoriaDto {

	private long id;

	private String descricao;

	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

}
