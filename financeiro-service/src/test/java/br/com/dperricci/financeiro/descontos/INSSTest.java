package br.com.dperricci.financeiro.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.dperricci.financeiro.descontos.inss.INSS;
import br.com.dperricci.financeiro.descontos.inss.INSSFaixaSalarial;
import br.com.dperricci.financeiro.descontos.inss.INSSParams;

public class INSSTest {

	@Test
	public void deveCalcularValorDescontoPorFaixaSalarial() {
		assertEquals(BigDecimal.valueOf(82.50).setScale(2, RoundingMode.HALF_EVEN), //
				INSSParams.PRIMEIRA_FAIXA_SALARIAL.setScale(2, RoundingMode.HALF_EVEN));
		assertEquals(BigDecimal.valueOf(99.31).setScale(2, RoundingMode.HALF_EVEN), //
				INSSParams.SEGUNDA_FAIXA_SALARIAL.setScale(2, RoundingMode.HALF_EVEN));
		assertEquals(BigDecimal.valueOf(132.21).setScale(2, RoundingMode.HALF_EVEN), //
				INSSParams.TERCEIRA_FAIXA_SALARIAL.setScale(2, RoundingMode.HALF_EVEN));
		assertEquals(BigDecimal.valueOf(437.97).setScale(2, RoundingMode.HALF_EVEN), //
				INSSParams.QUARTA_FAIXA_SALARIAL.setScale(2, RoundingMode.HALF_EVEN));
	}

	@Test
	public void deveCalcularDescontoDoInssParaAliquotaSeteMeio() {
		BigDecimal valorBruto = BigDecimal.valueOf(1100).setScale(2, RoundingMode.HALF_EVEN);
		INSSFaixaSalarial faixa = INSSFaixaSalarial.obterFaixa(valorBruto);
		INSS desconto = faixa.obterValor();
		assertEquals(BigDecimal.valueOf(82.50).setScale(2, RoundingMode.HALF_EVEN),
				desconto.calculaDesconto(valorBruto));
	}

	@Test
	public void deveCalcularDescontoDoInssParaAliquotaNove() {
		BigDecimal valorBruto = BigDecimal.valueOf(1987.33).setScale(2, RoundingMode.HALF_EVEN);
		INSSFaixaSalarial faixa = INSSFaixaSalarial.obterFaixa(valorBruto);
		INSS desconto = faixa.obterValor();
		assertEquals(BigDecimal.valueOf(162.36).setScale(2, RoundingMode.HALF_EVEN),
				desconto.calculaDesconto(valorBruto));
	}

	@Test
	public void deveCalcularDescontoDoInssParaAliquotaTeto() {
		BigDecimal valorBruto = BigDecimal.valueOf(8817.09).setScale(2, RoundingMode.HALF_EVEN);
		INSSFaixaSalarial faixa = INSSFaixaSalarial.obterFaixa(valorBruto);
		INSS desconto = faixa.obterValor();
		assertEquals(BigDecimal.valueOf(751.99).setScale(2, RoundingMode.HALF_EVEN),
				desconto.calculaDesconto(valorBruto).setScale(2, RoundingMode.HALF_EVEN));
	}
}
