package br.com.dperricci.financeiro.descontos.inss;

import java.math.BigDecimal;

public enum INSSFaixaSalarial {

	INSS_PRIMEIRA_FAIXA {
		@Override
		public INSS obterValor() {
			return new INSSPrimeiraFaixa();
		}
	},
	INSS_SEGUNDA_FAIXA {
		@Override
		public INSS obterValor() {
			return new INSSSegundaFaixa();
		}
	},
	INSS_TERCEIRA_FAIXA {
		@Override
		public INSS obterValor() {
			return new INSSTerceiraFaixa();
		}
	},
	INSS_QUARTA_FAIXA {
		@Override
		public INSS obterValor() {
			return new INSSQuartaFaixa();
		}
	},
	INSS_TETO {
		@Override
		public INSS obterValor() {
			return new INSSTeto();
		}
	};

	public abstract INSS obterValor();

	public static INSSFaixaSalarial obterFaixa(BigDecimal valorBruto) {
		if (valorBruto.compareTo(INSSParams.BASE) <= 0) {
			return INSS_PRIMEIRA_FAIXA;
		} else if (valorBruto.compareTo(INSSParams.BASE_FAIXA_2_INI) >= 0
				&& valorBruto.compareTo(INSSParams.BASE_FAIXA_2_FIN) <= 0) {
			return INSS_SEGUNDA_FAIXA;
		} else if (valorBruto.compareTo(INSSParams.BASE_FAIXA_3_INI) >= 0
				&& valorBruto.compareTo(INSSParams.BASE_FAIXA_3_FIN) <= 0) {
			return INSS_TERCEIRA_FAIXA;
		} else if (valorBruto.compareTo(INSSParams.BASE_FAIXA_4_INI) >= 0
				&& valorBruto.compareTo(INSSParams.BASE_FAIXA_4_FIN) <= 0) {
			return INSS_QUARTA_FAIXA;
		} else {
			return INSS_TETO;
		}

	}
}
