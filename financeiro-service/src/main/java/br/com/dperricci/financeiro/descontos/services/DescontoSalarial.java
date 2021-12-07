package br.com.dperricci.financeiro.descontos.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import br.com.dperricci.financeiro.descontos.inss.INSS;
import br.com.dperricci.financeiro.descontos.inss.INSSFaixaSalarial;
import br.com.dperricci.financeiro.descontos.irrf.IRRF;
import br.com.dperricci.financeiro.descontos.irrf.IRRFFaixaSalarial;
import br.com.dperricci.financeiro.descontos.irrf.IRRFParams;

public class DescontoSalarial {

	private final BigDecimal valorBruto;
	private final int dependentes;
	private final List<Desconto> descontos;
	private BigDecimal valorLiquido = BigDecimal.ZERO;

	public DescontoSalarial(BigDecimal valorBruto, int dependentes, List<Desconto> descontos) {
		this.valorBruto = valorBruto;
		this.dependentes = dependentes;
		this.descontos = descontos;
	}

	public BigDecimal calculaSalarioLiquido() {
		aplicaDescontoINSS();
		aplicaDescontoIRRF();
		for (Desconto desconto : descontos) {
			this.valorLiquido = desconto.calculaDesconto(valorLiquido);
		}

		return this.valorLiquido;
	}

	private void aplicaDescontoINSS() {
		this.valorLiquido = this.valorBruto//
				.subtract(descontoINSS());
	}

	private void aplicaDescontoIRRF() {
		this.valorLiquido = this.valorLiquido//
				.subtract(descontoIRRF());
	}

	private BigDecimal descontoINSS() {
		INSSFaixaSalarial faixa = INSSFaixaSalarial.obterFaixa(valorBruto);
		INSS inss = faixa.obterValor();
		return inss.calculaDesconto(valorBruto).setScale(2, RoundingMode.HALF_EVEN);
	}

	private BigDecimal obterSalarioBase() {
		BigDecimal salarioBase = this.valorBruto.subtract(descontoINSS());
		BigDecimal descontoPorDependente = IRRFParams.PARCELA_DEDUTIVEL_POR_DEPENDENTE
				.multiply(BigDecimal.valueOf(dependentes));
		return salarioBase.subtract(descontoPorDependente);
	}

	private BigDecimal descontoIRRF() {
		BigDecimal salarioBase = obterSalarioBase();
		IRRFFaixaSalarial faixa = IRRFFaixaSalarial.obterFaixa(salarioBase);
		IRRF irrf = faixa.obterValor();
		return irrf.calculaDesconto(salarioBase).setScale(2, RoundingMode.HALF_EVEN);
	}
}
