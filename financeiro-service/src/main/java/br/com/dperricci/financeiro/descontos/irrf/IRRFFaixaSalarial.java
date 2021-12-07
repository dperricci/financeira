package br.com.dperricci.financeiro.descontos.irrf;

import java.math.BigDecimal;

public enum IRRFFaixaSalarial {

	IRRF_PRIMEIRA_FAIXA {
		@Override
		public IRRF obterValor() {
			return new IRRFPrimeiraFaixa();
		}
	},
	IRRF_SEGUNDA_FAIXA {
		@Override
		public IRRF obterValor() {
			return new IRRFSegundaFaixa();
		}
	},
	IRRF_TERCEIRA_FAIXA {
		@Override
		public IRRF obterValor() {
			return new IRRFTerceiraFaixa();
		}
	},
	IRRF_QUARTA_FAIXA {
		@Override
		public IRRF obterValor() {
			return new IRRFQuartaFaixa();
		}
	},
	IRRF_QUINTA_FAIXA {
		@Override
		public IRRF obterValor() {
			return new IRRFQuintaFaixa();
		}
	};

	public abstract IRRF obterValor();

	public static IRRFFaixaSalarial obterFaixa(BigDecimal salarioBase) {

		if (salarioBase.compareTo(IRRFParams.BASE) <= 0) {
			return IRRF_PRIMEIRA_FAIXA;
		} else if (salarioBase.compareTo(IRRFParams.BASE_FAIXA_2_INI) >= 0
				&& salarioBase.compareTo(IRRFParams.BASE_FAIXA_2_FIN) <= 0) {
			return IRRF_SEGUNDA_FAIXA;
		} else if (salarioBase.compareTo(IRRFParams.BASE_FAIXA_3_INI) >= 0
				&& salarioBase.compareTo(IRRFParams.BASE_FAIXA_3_FIN) <= 0) {
			return IRRF_TERCEIRA_FAIXA;
		} else if (salarioBase.compareTo(IRRFParams.BASE_FAIXA_4_INI) >= 0
				&& salarioBase.compareTo(IRRFParams.BASE_FAIXA_4_FIN) <= 0) {
			return IRRF_QUARTA_FAIXA;
		} else {
			return IRRF_QUINTA_FAIXA;
		}

	}
}
