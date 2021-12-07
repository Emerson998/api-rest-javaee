package br.com.magna.pea2.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;
	@OneToOne
	private LocadoraModel locadora;

	public ClienteModel() {
	}

	public ClienteModel(Long id, String cpf, String nome, LocadoraModel locadora) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.locadora = locadora;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocadoraModel getLocadora() {
		return locadora;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLocadora(LocadoraModel locadora) {
		this.locadora = locadora;
	}

	@Override
	public String toString() {
		return "LocadoraModel [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", locadora=" + locadora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, locadora, id, nome);
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
		return Objects.equals(cpf, other.cpf) && Objects.equals(locadora, other.locadora) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
}
