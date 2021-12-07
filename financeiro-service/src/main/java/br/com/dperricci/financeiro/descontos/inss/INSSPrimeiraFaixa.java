package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class INSSPrimeiraFaixa implements INSS {

	@Override
	public BigDecimal calculaDesconto(BigDecimal valorBruto) {
		return valorBruto.multiply(INSSParams.ALIQUOTA_PRIMEIRA_FAIXA)//
				.setScale(2, RoundingMode.HALF_EVEN);
	}
}
