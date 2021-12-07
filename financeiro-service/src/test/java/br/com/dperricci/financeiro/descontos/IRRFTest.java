package br.com.dperricci.financeiro.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.dperricci.financeiro.descontos.inss.INSS;
import br.com.dperricci.financeiro.descontos.inss.INSSFaixaSalarial;
import br.com.dperricci.financeiro.descontos.irrf.IRRF;
import br.com.dperricci.financeiro.descontos.irrf.IRRFFaixaSalarial;
import br.com.dperricci.financeiro.descontos.irrf.IRRFParams;

public class IRRFTest {

	@Test
	public void deveCalcularDescontoIRRF_ParaPrimeiraFaixa() {
		BigDecimal salarioBase = BigDecimal.valueOf(827.91);
		IRRFFaixaSalarial faixaIRRF = IRRFFaixaSalarial.obterFaixa(salarioBase);
		IRRF irrf = faixaIRRF.obterValor();

		assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_EVEN), //
				irrf.calculaDesconto(salarioBase)//
						.setScale(2, RoundingMode.HALF_EVEN));

	}

	@Test
	public void deveCalcularDescontoIRRF_ParaTerceiraFaixa() {
		BigDecimal salarioBase = BigDecimal.valueOf(2533.02);
		IRRFFaixaSalarial faixaIRRF = IRRFFaixaSalarial.obterFaixa(salarioBase);
		IRRF irrf = faixaIRRF.obterValor();

		assertEquals(BigDecimal.valueOf(47.18).setScale(2, RoundingMode.HALF_EVEN), //
				irrf.calculaDesconto(salarioBase)//
						.setScale(2, RoundingMode.HALF_EVEN));

	}

	@Test
	public void deveCalcularDescontoIRRF_ParaQuintaFaixa() {
		BigDecimal salarioBase = BigDecimal.valueOf(9850.3925);
		IRRFFaixaSalarial faixaIRRF = IRRFFaixaSalarial.obterFaixa(salarioBase);
		IRRF irrf = faixaIRRF.obterValor();

		assertEquals(BigDecimal.valueOf(1839.50).setScale(2, RoundingMode.HALF_EVEN), //
				irrf.calculaDesconto(salarioBase)//
						.setScale(2, RoundingMode.HALF_EVEN));

	}
}
