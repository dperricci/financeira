package br.com.dperricci.financeiro.descontos.services;

import java.math.BigDecimal;

public class Adicional implements Desconto {

	private final BigDecimal desconto;

	public Adicional(BigDecimal desconto) {
		this.desconto = desconto;
	}

	@Override
	public BigDecimal calculaDesconto(BigDecimal valor) {
		return valor.subtract(desconto);
	}
}
