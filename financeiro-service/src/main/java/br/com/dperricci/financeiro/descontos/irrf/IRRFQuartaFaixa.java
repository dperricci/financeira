package br.com.dperricci.financeiro.descontos.irrf;

import java.math.BigDecimal;

public class IRRFQuartaFaixa implements IRRF {

	@Override
	public BigDecimal calculaDesconto(BigDecimal salarioBase) {
		BigDecimal desconto = salarioBase.multiply(IRRFParams.ALIQUOTA_QUARTA_FAIXA);
		return desconto.subtract(IRRFParams.PARCELA_DEDUTIVEL_QUARTA_FAIXA);
	}
}
