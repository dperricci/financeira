package br.com.dperricci.financeiro.descontos.irrf;

import java.math.BigDecimal;

public class IRRFSegundaFaixa implements IRRF {

	@Override
	public BigDecimal calculaDesconto(BigDecimal salarioBase) {
		BigDecimal desconto = salarioBase.multiply(IRRFParams.ALIQUOTA_SEGUNDA_FAIXA);
		return desconto.subtract(IRRFParams.PARCELA_DEDUTIVEL_SEGUNDA_FAIXA);
	}
}
