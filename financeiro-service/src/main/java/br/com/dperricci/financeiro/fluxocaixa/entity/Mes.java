package br.com.dperricci.financeiro.fluxocaixa.entity;

import java.util.List;

import br.com.dperricci.financeiro.despesas.entity.Despesa;
import br.com.dperricci.financeiro.fluxocaixa.utils.MesEnum;
import br.com.dperricci.financeiro.investimentos.entity.Investimento;
import br.com.dperricci.financeiro.receitas.entity.Receita;

public class Mes {

	private List<Receita> receitas;
	private MesEnum mes;
	private List<Despesa> despesas;
	private List<Investimento> investimentos;

}
