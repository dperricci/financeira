package br.com.dperricci.financeiro.receitas.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.dperricci.financeiro.descontos.services.Desconto;
import br.com.dperricci.financeiro.descontos.services.DescontoSalarial;

public class Salario {

	private final BigDecimal valorBruto;
	private final int dependentes;

	private List<Desconto> descontos = new ArrayList<Desconto>();

	public Salario(BigDecimal salarioBruto, int dependentes) {
		this.valorBruto = salarioBruto;
		this.dependentes = dependentes;
	}

	public BigDecimal getSalarioLiquido() {
		DescontoSalarial desconto = new DescontoSalarial(valorBruto, dependentes, descontos);
		return desconto.calculaSalarioLiquido();
	}

	public void adicionaDesconto(Desconto desconto) {
		descontos.add(desconto);
	}

	public void adicionaDesconto(List<Desconto> descontos) {
		descontos.addAll(descontos);
	}

}
