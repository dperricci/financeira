package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;

public class INSSTeto implements INSS {

	@Override
	public BigDecimal calculaDesconto(BigDecimal valorBruto) {
		return INSSParams.PRIMEIRA_FAIXA_SALARIAL.add(INSSParams.SEGUNDA_FAIXA_SALARIAL)
				.add(INSSParams.TERCEIRA_FAIXA_SALARIAL).add(INSSParams.QUARTA_FAIXA_SALARIAL);
	}
}
