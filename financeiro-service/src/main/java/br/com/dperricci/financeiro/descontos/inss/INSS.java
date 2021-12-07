package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;

import br.com.dperricci.financeiro.descontos.services.Desconto;

public interface INSS extends Desconto{

	public BigDecimal calculaDesconto(BigDecimal valorBruto);

}
