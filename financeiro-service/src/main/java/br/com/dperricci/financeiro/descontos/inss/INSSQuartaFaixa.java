package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class INSSQuartaFaixa implements INSS {

	@Override
	public BigDecimal calculaDesconto(BigDecimal valorBruto) {
		BigDecimal desconto = (valorBruto.subtract(INSSParams.BASE_FAIXA_4_INI)).multiply(INSSParams.ALIQUOTA_QUARTA_FAIXA);
		return desconto.add(INSSParams.TERCEIRA_FAIXA_SALARIAL)//
				.add(INSSParams.SEGUNDA_FAIXA_SALARIAL)//
				.add(INSSParams.PRIMEIRA_FAIXA_SALARIAL)//
				.setScale(2, RoundingMode.HALF_EVEN);
	}
}
