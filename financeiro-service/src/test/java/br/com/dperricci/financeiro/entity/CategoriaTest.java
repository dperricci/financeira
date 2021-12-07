package br.com.dperricci.financeiro.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.dperricci.financeiro.despesas.controller.dto.CategoriaDto;
import br.com.dperricci.financeiro.despesas.controller.dto.SubCategoriaDto;
import br.com.dperricci.financeiro.despesas.entity.Categoria;
import br.com.dperricci.financeiro.share.builder.CategoriaBuilder;

public class CategoriaTest {

	@Test
	public void deveConverterCategoriaToEntity() {
		CategoriaDto dto = new CategoriaDto();
		dto.setDescricao("Lazer");
		dto.getSubCategorias().add(new SubCategoriaDto(1L, "Cinema"));
		dto.getSubCategorias().add(new SubCategoriaDto(1L, "Shopping"));

		Categoria entity = new Categoria().toEntity(dto);

		assertEquals("LAZER", entity.getDescricao());
		assertEquals(2, entity.getSubCategorias().size());
		assertEquals("CINEMA", entity.getSubCategorias().get(0).getDescricao());
		assertEquals("SHOPPING", entity.getSubCategorias().get(1).getDescricao());
	}

	@Test
	public void deveConverterCategoriaToDto() {
		Categoria entity = new CategoriaBuilder()//
				.categoria("Moradia")//
				.addSubCategoria("Luz")//
				.addSubCategoria("Agua")//
				.addSubCategoria("Gas")//
				.build();

		CategoriaDto dto = new CategoriaDto(entity);
		assertEquals("MORADIA", dto.getDescricao());
		assertEquals(3, dto.getSubCategorias().size());
		assertEquals("LUZ", dto.getSubCategorias().get(0).getDescricao());
		assertEquals("AGUA", dto.getSubCategorias().get(1).getDescricao());
		assertEquals("GAS", dto.getSubCategorias().get(2).getDescricao());

	}
}
