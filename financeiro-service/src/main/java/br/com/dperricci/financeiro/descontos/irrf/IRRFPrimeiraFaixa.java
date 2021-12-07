package br.com.dperricci.financeiro.descontos.irrf;

import java.math.BigDecimal;

public class IRRFPrimeiraFaixa implements IRRF {

	@Override
	public BigDecimal calculaDesconto(BigDecimal salarioBase) {
		BigDecimal desconto = salarioBase.multiply(IRRFParams.ALIQUOTA_PRIMEIRA_FAIXA);
		return desconto.subtract(IRRFParams.PARCELA_DEDUTIVEL_PRIMEIRA_FAIXA);
	}
}
