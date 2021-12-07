package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;

public class INSSParams {

	public static final BigDecimal BASE = BigDecimal.valueOf(1100);
	public static final BigDecimal BASE_FAIXA_2_INI = BigDecimal.valueOf(1100.01);
	public static final BigDecimal BASE_FAIXA_2_FIN = BigDecimal.valueOf(2203.48);
	public static final BigDecimal BASE_FAIXA_3_INI = BigDecimal.valueOf(2203.49);
	public static final BigDecimal BASE_FAIXA_3_FIN = BigDecimal.valueOf(3305.22);
	public static final BigDecimal BASE_FAIXA_4_INI = BigDecimal.valueOf(3305.23);
	public static final BigDecimal BASE_FAIXA_4_FIN = BigDecimal.valueOf(6433.57);

	public static final BigDecimal ALIQUOTA_PRIMEIRA_FAIXA = BigDecimal.valueOf(0.075);
	public static final BigDecimal ALIQUOTA_SEGUNDA_FAIXA = BigDecimal.valueOf(0.09);
	public static final BigDecimal ALIQUOTA_TERCEIRA_FAIXA = BigDecimal.valueOf(0.12);
	public static final BigDecimal ALIQUOTA_QUARTA_FAIXA = BigDecimal.valueOf(0.14);

	public static final BigDecimal DIFF_FAIXA_2 = BASE_FAIXA_2_FIN.subtract(BASE_FAIXA_2_INI);
	public static final BigDecimal DIFF_FAIXA_3 = BASE_FAIXA_3_FIN.subtract(BASE_FAIXA_3_INI);
	public static final BigDecimal DIFF_FAIXA_4 = BASE_FAIXA_4_FIN.subtract(BASE_FAIXA_4_INI);

	public static final BigDecimal PRIMEIRA_FAIXA_SALARIAL = BASE.multiply(ALIQUOTA_PRIMEIRA_FAIXA);
	public static final BigDecimal SEGUNDA_FAIXA_SALARIAL = DIFF_FAIXA_2.multiply(ALIQUOTA_SEGUNDA_FAIXA);
	public static final BigDecimal TERCEIRA_FAIXA_SALARIAL = DIFF_FAIXA_3.multiply(ALIQUOTA_TERCEIRA_FAIXA);
	public static final BigDecimal QUARTA_FAIXA_SALARIAL = DIFF_FAIXA_4.multiply(ALIQUOTA_QUARTA_FAIXA);

}
