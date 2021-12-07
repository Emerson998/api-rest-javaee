package br.com.magna.pea2.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class FornecedorModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	@OneToOne(fetch = FetchType.EAGER)
	private LocadoraModel locadora;

	public FornecedorModel() {
	}

	public FornecedorModel(Long id, String nome, String cnpj, LocadoraModel locadora) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.locadora = locadora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocadoraModel getLocadora() {
		return locadora;
	}

	public void setLocadora(LocadoraModel locadora) {
		this.locadora = locadora;
	}

	@Override
	public String toString() {
		return "FornecedorModel [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", locadora=" + locadora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id, locadora, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorModel other = (FornecedorModel) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id)
				&& Objects.equals(locadora, other.locadora) && Objects.equals(nome, other.nome);
	}

}
