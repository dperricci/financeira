package br.com.dperricci.financeiro.despesas.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dperricci.financeiro.despesas.entity.Despesa;
import br.com.dperricci.financeiro.despesas.entity.FormaPagamento;
import br.com.dperricci.financeiro.despesas.entity.Periodicidade;

@SpringBootTest
public class DespesaRepositoryTest {

	@Autowired
	private DespesaRepository despesaRepo;

	@Test
	@Transactional
	public void deveSalvarUmaDespesa() {
		Despesa despesa = new Despesa();
		despesa.setSubCategoria(1L);
		despesa.setDataDaDespesa(LocalDateTime.of(2021, 10, 01, 0, 0));
		despesa.setDataVencimento(LocalDateTime.of(2021, 11, 01, 0, 0));
		despesa.setDescricao("Claro Internet");
		despesa.setFormaDePagamento(FormaPagamento.DEBITO_AUTOMATICO);
		despesa.setPeriodicidade(Periodicidade.FIXA);
		despesa.setValor(BigDecimal.valueOf(352.86));

		Despesa entity = despesaRepo.save(despesa);
		assertNotNull(entity);
	}

}
