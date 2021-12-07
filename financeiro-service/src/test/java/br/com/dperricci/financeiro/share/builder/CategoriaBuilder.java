package br.com.dperricci.financeiro.share.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.dperricci.financeiro.despesas.entity.Categoria;
import br.com.dperricci.financeiro.despesas.entity.SubCategoria;

public class CategoriaBuilder {

	private String categoria;
	private List<SubCategoria> subCategoriaList = new ArrayList<>();

	public CategoriaBuilder categoria(String categoria) {
		this.categoria = categoria;
		return this;
	}

	public CategoriaBuilder addSubCategoria(String subCategoria) {
		this.subCategoriaList.add(getSubCategoria(subCategoria));
		return this;
	}

	public Categoria build() {
		Categoria entity = new Categoria();
		entity.setDescricao(this.categoria);
		entity.addSubCategoria(this.subCategoriaList);
		return entity;
	}

	private SubCategoria getSubCategoria(String subCategoria) {
		return SubCategoria.builder()//
				.descricao(subCategoria)//
				.build();
	}
}
