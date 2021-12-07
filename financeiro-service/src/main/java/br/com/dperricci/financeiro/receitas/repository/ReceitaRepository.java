package br.com.dperricci.financeiro.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dperricci.financeiro.receitas.entity.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
