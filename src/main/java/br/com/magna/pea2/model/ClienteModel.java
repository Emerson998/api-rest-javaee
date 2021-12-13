package br.com.magna.pea2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private long senha;
	private LocalDate data = LocalDate.now();
	private String endereco;
	@OneToOne
	private LocadoraModel locadora;

	public ClienteModel() {
	}

	public ClienteModel(Long id, String cpf, long senha, LocalDate data, String endereco, LocadoraModel locadora) {
		this.id = id;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		return "ClienteModel [id=" + id + ", cpf=" + cpf + ", senha=" + senha + ", data=" + data + ", endereco="
				+ endereco + ", locadora=" + locadora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, data, endereco, id, locadora, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(data, other.data)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(locadora, other.locadora) && senha == other.senha;
	}

}
