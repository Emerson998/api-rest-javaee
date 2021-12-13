package br.com.magna.pea2.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ClienteDto {

	private String cpf;
	private long senha;
	private LocalDate data = LocalDate.now();
	private String endereco;

	public ClienteDto() {

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

	@Override
	public String toString() {
		return "ClienteDto [cpf=" + cpf + ", senha=" + senha + ", data=" + data + ", endereco=" + endereco + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, data, endereco, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDto other = (ClienteDto) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(data, other.data)
				&& Objects.equals(endereco, other.endereco) && senha == other.senha;
	}

}