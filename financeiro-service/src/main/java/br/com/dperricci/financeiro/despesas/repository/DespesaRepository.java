package br.com.dperricci.financeiro.despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dperricci.financeiro.despesas.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
