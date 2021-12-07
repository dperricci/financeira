package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class INSSSegundaFaixa implements INSS {

	@Override
	public BigDecimal calculaDesconto(BigDecimal valorBruto) {
		BigDecimal desconto = (valorBruto.subtract(INSSParams.BASE_FAIXA_2_INI)).multiply(INSSParams.ALIQUOTA_SEGUNDA_FAIXA);
		return desconto.add(INSSParams.PRIMEIRA_FAIXA_SALARIAL)//
				.setScale(2, RoundingMode.HALF_EVEN);
	}
}
