package br.com.dperricci.financeiro.despesas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dperricci.financeiro.despesas.controller.dto.CategoriaDto;
import br.com.dperricci.financeiro.despesas.controller.dto.SubCategoriaDto;

@SpringBootTest
public class CategoriaServiceTest {

	@Autowired
	private CategoriaService service;

	@Test
	@Transactional
	public void deveSalvarCategoria() {
		CategoriaDto categoria = criaCategoria();

		CategoriaDto cat = service.salvar(categoria);
		assertNotNull(cat);
		assertEquals("MORADIA", cat.getDescricao());
		assertEquals(3, cat.getSubCategorias().size());

		List<CategoriaDto> list = service.listarCategorias();
		assertTrue(list.size() == 1);
		assertEquals("MORADIA", list.get(0).getDescricao());
		assertEquals(3, list.get(0).getSubCategorias().size());
	}

	@Test
	@Transactional
	public void deveAtualizarCategoria() throws CategoriaException {
		CategoriaDto categoria = criaCategoria();
		CategoriaDto cat = service.salvar(categoria);
		cat.setDescricao("CASA");
		cat.getSubCategorias().remove(0);
		cat = service.atualizar(cat);
		assertNotNull(cat);
		assertEquals("CASA", cat.getDescricao());
		assertEquals(2, cat.getSubCategorias().size());
	}

	private SubCategoriaDto getSubCategoria(String subCategoria) {
		return SubCategoriaDto.builder()//
				.descricao(subCategoria)//
				.build();
	}

	private CategoriaDto criaCategoria() {
		CategoriaDto categoria = new CategoriaDto();
		categoria.setDescricao("Moradia");
		categoria.getSubCategorias().add(getSubCategoria("Luz"));
		categoria.getSubCategorias().add(getSubCategoria("Gas"));
		categoria.getSubCategorias().add(getSubCategoria("Internet"));
		return categoria;
	}
}
