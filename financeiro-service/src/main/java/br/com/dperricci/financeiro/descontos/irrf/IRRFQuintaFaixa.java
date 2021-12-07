package br.com.dperricci.financeiro.descontos.irrf;

import java.math.BigDecimal;

public class IRRFQuintaFaixa implements IRRF {

	@Override
	public BigDecimal calculaDesconto(BigDecimal salarioBase) {
		BigDecimal desconto = salarioBase.multiply(IRRFParams.ALIQUOTA_QUINTA_FAIXA);
		return desconto.subtract(IRRFParams.PARCELA_DEDUTIVEL_QUINTA_FAIXA);
	}

}
