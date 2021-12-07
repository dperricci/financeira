package br.com.dperricci.financeiro.despesas.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime dataDaDespesa;
	private LocalDateTime dataVencimento;
	private String descricao;
	private Long subCategoria;
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private Periodicidade periodicidade;
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaDePagamento;
	private String observacoes;

}
