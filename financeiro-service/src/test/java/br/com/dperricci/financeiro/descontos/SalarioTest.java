package br.com.dperricci.financeiro.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.dperricci.financeiro.descontos.services.Adicional;
import br.com.dperricci.financeiro.receitas.services.Salario;

public class SalarioTest {

	@Test
	public void deveCalcularSalarioLiquido() {
		Salario salario = new Salario(BigDecimal.valueOf(10791.97), 1);
		assertEquals(BigDecimal.valueOf(8200.48).setScale(2, RoundingMode.HALF_EVEN), //
				salario.getSalarioLiquido().setScale(2, RoundingMode.HALF_EVEN));
	}

	@Test
	public void deveCalcularSalarioLiquido_DescontoVR() {
		Salario salario = new Salario(BigDecimal.valueOf(8817.09), 0);
		salario.adicionaDesconto(new Adicional(BigDecimal.valueOf(40.86)));
		assertEquals(BigDecimal.valueOf(6675.70).setScale(2, RoundingMode.HALF_EVEN), //
				salario.getSalarioLiquido().setScale(2, RoundingMode.HALF_EVEN));
	}

	@Test
	public void deveCalcularSalarioLiquido_DescontoAdicionais() {
		Salario salario = new Salario(BigDecimal.valueOf(8817.09), 0);
		salario.adicionaDesconto(new Adicional(BigDecimal.valueOf(40.86)));
		salario.adicionaDesconto(new Adicional(BigDecimal.valueOf(21.60)));
		salario.adicionaDesconto(new Adicional(BigDecimal.valueOf(574.77)));
		assertEquals(BigDecimal.valueOf(6079.33).setScale(2, RoundingMode.HALF_EVEN), //
				salario.getSalarioLiquido().setScale(2, RoundingMode.HALF_EVEN));
	}
}
