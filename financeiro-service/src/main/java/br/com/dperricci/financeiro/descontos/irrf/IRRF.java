package br.com.dperricci.financeiro.descontos.irrf;

import java.math.BigDecimal;

import br.com.dperricci.financeiro.descontos.services.Desconto;

public interface IRRF extends Desconto {

	public BigDecimal calculaDesconto(BigDecimal valorComDescontoInss);
}
