package br.com.dperricci.financeiro.despesas.service;

public class CategoriaException extends Exception {

	private static final long serialVersionUID = 789915991640137660L;

	public CategoriaException(String mensagem) {
		super(mensagem);
	}

	public CategoriaException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}
}
