package br.com.dperricci.financeiro.despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dperricci.financeiro.despesas.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByDescricao(String descricao);
}
