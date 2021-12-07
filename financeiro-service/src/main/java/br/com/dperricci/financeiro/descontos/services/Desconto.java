package br.com.dperricci.financeiro.descontos.services;

import java.math.BigDecimal;

public interface Desconto {

	public BigDecimal calculaDesconto(BigDecimal valorBruto);
}
