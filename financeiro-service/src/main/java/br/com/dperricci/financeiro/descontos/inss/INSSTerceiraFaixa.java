package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class INSSTerceiraFaixa implements INSS {

	@Override
	public BigDecimal calculaDesconto(BigDecimal valorBruto) {
		BigDecimal desconto = (valorBruto.subtract(INSSParams.BASE_FAIXA_3_INI))//
				.multiply(INSSParams.ALIQUOTA_TERCEIRA_FAIXA);
		return desconto.add(INSSParams.SEGUNDA_FAIXA_SALARIAL)//
				.add(INSSParams.PRIMEIRA_FAIXA_SALARIAL)//
				.setScale(2, RoundingMode.HALF_EVEN);
	}

}
