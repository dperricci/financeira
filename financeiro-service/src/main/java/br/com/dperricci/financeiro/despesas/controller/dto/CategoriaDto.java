package br.com.dperricci.financeiro.despesas.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dperricci.financeiro.despesas.entity.Categoria;
import br.com.dperricci.financeiro.despesas.entity.SubCategoria;
import lombok.ToString;

@ToString
public class CategoriaDto {

	private long id;
	private String descricao;
	private List<SubCategoriaDto> subCategorias = new ArrayList<>();

	public CategoriaDto() {
	}

	public CategoriaDto(Categoria entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.subCategorias = entityToDto(entity.getSubCategorias());
	};

	public List<CategoriaDto> toDto(List<Categoria> entity) {
		return entity.stream().map(CategoriaDto::new)//
				.collect(Collectors.toList());
	}

	private List<SubCategoriaDto> entityToDto(List<SubCategoria> entity) {
		return entity.stream()//
				.map(subCat -> new SubCategoriaDto(subCat.getId(), subCat.getDescricao()))//
				.collect(Collectors.toList());
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public List<SubCategoriaDto> getSubCategorias() {
		return subCategorias;
	}

}
