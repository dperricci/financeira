package br.com.dperricci.financeiro.descontos.irrf;

import java.math.BigDecimal;

public class IRRFParams {

	public static final BigDecimal BASE = BigDecimal.valueOf(1903.98);
	public static final BigDecimal BASE_FAIXA_2_INI = BigDecimal.valueOf(1903.99);
	public static final BigDecimal BASE_FAIXA_2_FIN = BigDecimal.valueOf(2826.65);
	public static final BigDecimal BASE_FAIXA_3_INI = BigDecimal.valueOf(2826.66);
	public static final BigDecimal BASE_FAIXA_3_FIN = BigDecimal.valueOf(3751.05);
	public static final BigDecimal BASE_FAIXA_4_INI = BigDecimal.valueOf(3751.06);
	public static final BigDecimal BASE_FAIXA_4_FIN = BigDecimal.valueOf(4664.68);

	public static final BigDecimal ALIQUOTA_PRIMEIRA_FAIXA = BigDecimal.valueOf(0.0);
	public static final BigDecimal ALIQUOTA_SEGUNDA_FAIXA = BigDecimal.valueOf(0.075);
	public static final BigDecimal ALIQUOTA_TERCEIRA_FAIXA = BigDecimal.valueOf(0.15);
	public static final BigDecimal ALIQUOTA_QUARTA_FAIXA = BigDecimal.valueOf(0.225);
	public static final BigDecimal ALIQUOTA_QUINTA_FAIXA = BigDecimal.valueOf(0.275);

	public static final BigDecimal PARCELA_DEDUTIVEL_PRIMEIRA_FAIXA = BigDecimal.valueOf(0.0);
	public static final BigDecimal PARCELA_DEDUTIVEL_SEGUNDA_FAIXA = BigDecimal.valueOf(142.80);
	public static final BigDecimal PARCELA_DEDUTIVEL_TERCEIRA_FAIXA = BigDecimal.valueOf(354.80);
	public static final BigDecimal PARCELA_DEDUTIVEL_QUARTA_FAIXA = BigDecimal.valueOf(636.13);
	public static final BigDecimal PARCELA_DEDUTIVEL_QUINTA_FAIXA = BigDecimal.valueOf(869.36);

	public static final BigDecimal PARCELA_DEDUTIVEL_POR_DEPENDENTE = BigDecimal.valueOf(189.59);

}
