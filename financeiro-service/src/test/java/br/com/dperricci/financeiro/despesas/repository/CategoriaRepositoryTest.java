package br.com.dperricci.financeiro.despesas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dperricci.financeiro.despesas.entity.Categoria;
import br.com.dperricci.financeiro.despesas.entity.SubCategoria;
import br.com.dperricci.financeiro.share.builder.CategoriaBuilder;

@SpringBootTest
public class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Test
	@Transactional
	public void deveSalvarCategoriaNoBanco() {
		criaCategoria();
		Categoria result = categoriaRepo.findAll().get(0);
		assertNotNull(result);
		assertEquals(3, result.getSubCategorias().size());
	}

	@Test
	@Transactional
	public void deveBuscarCategoriaPorId() {
		Categoria categoria = new CategoriaBuilder()//
				.categoria("Moradia")//
				.addSubCategoria("Luz")//
				.addSubCategoria("Gas")//
				.addSubCategoria("Internet")//
				.build();
		categoria = categoriaRepo.save(categoria);

		Optional<Categoria> result = categoriaRepo.findById(categoria.getId());
		assertNotNull(result);
		assertEquals(3, result.get().getSubCategorias().size());
	}

	@Test
	@Transactional
	public void deveBuscarCategoriaPorDescricao() {
		criaCategoria();
		Categoria result = categoriaRepo.findByDescricao("MORADIA");
		assertNotNull(result);
		assertEquals(3, result.getSubCategorias().size());
	}

	@Test
	@Transactional
	public void deveAtualizarSubCategoria() {
		criaCategoria();
		Categoria result = categoriaRepo.findByDescricao("MORADIA");
		result.setDescricao("CASA");
		result.removeSubCategoria(result.getSubCategorias().get(0));
		assertNotNull(result);
		assertEquals("CASA", result.getDescricao());
		assertEquals(2, result.getSubCategorias().size());
	}

	private void criaCategoria() {
		Categoria categoria = new CategoriaBuilder()//
				.categoria("Moradia")//
				.addSubCategoria("Luz")//
				.addSubCategoria("Gas")//
				.addSubCategoria("Internet")//
				.build();
		categoriaRepo.save(categoria);
	}
}
