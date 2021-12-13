package br.com.magna.pea2.model;

import java.io.Serializable;
import java.time.LocalDate;
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
	private String cnpj;
	private long senha;
	private LocalDate data = LocalDate.now();
	private String endereco;

	@OneToOne(fetch = FetchType.EAGER)
	private LocadoraModel locadora;

	public FornecedorModel() {
	}

	public FornecedorModel(Long id, String cnpj, long senha, LocalDate data, String endereco, LocadoraModel locadora) {
		this.id = id;
		this.cnpj = cnpj;
		this.senha = senha;
		this.data = data;
		this.endereco = endereco;
		this.locadora = locadora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public long getSenha() {
		return senha;
	}

	public void setSenha(long senha) {
		this.senha = senha;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocadoraModel getLocadora() {
		return locadora;
	}

	public void setLocadora(LocadoraModel locadora) {
		this.locadora = locadora;
	}

	@Override
	public String toString() {
		return "FornecedorModel [id=" + id + ", cnpj=" + cnpj + ", senha=" + senha + ", data=" + data + ", endereco="
				+ endereco + ", locadora=" + locadora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, data, endereco, id, locadora, senha);
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
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(data, other.data)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(locadora, other.locadora) && senha == other.senha;
	}

}
