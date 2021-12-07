package br.com.dperricci.financeiro.despesas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	private String descricao;
	@ManyToOne
	@Setter
	private Categoria categoria;

	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
