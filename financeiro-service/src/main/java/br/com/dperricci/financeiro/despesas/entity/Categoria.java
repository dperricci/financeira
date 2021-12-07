package br.com.dperricci.financeiro.despesas.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.dperricci.financeiro.despesas.controller.dto.CategoriaDto;
import br.com.dperricci.financeiro.despesas.controller.dto.SubCategoriaDto;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	private String descricao;
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<SubCategoria> subCategorias = new ArrayList<>();

	public void addSubCategoria(SubCategoria subCategoria) {
		subCategoria.setCategoria(this);
		this.subCategorias.add(subCategoria);
	}

	public void removeSubCategoria(SubCategoria subCategoria) {
		this.subCategorias.remove(subCategoria);
	}

	public void addSubCategoria(List<SubCategoria> subCategoriaList) {
		subCategoriaList.stream().forEach(sub -> addSubCategoria(sub));
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}

	public Categoria toEntity(CategoriaDto dto) {
		this.descricao = dto.getDescricao();
		List<SubCategoria> subCategorias = dtoToEntity(dto.getSubCategorias());
		subCategorias.forEach(sub -> addSubCategoria(sub));
		return this;
	}

	private List<SubCategoria> dtoToEntity(List<SubCategoriaDto> dto) {
		return dto.stream()//
				.map(subDto -> new SubCategoria(subDto.getId(), subDto.getDescricao(), this))//
				.collect(Collectors.toList());
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public List<SubCategoria> getSubCategorias() {
		return subCategorias;
	}

}
