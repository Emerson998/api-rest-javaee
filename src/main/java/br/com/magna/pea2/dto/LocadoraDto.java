package br.com.magna.pea2.dto;

import java.time.LocalDate;
import java.util.Objects;

public class LocadoraDto {

	private String cnpj;
	private long senha;
	private LocalDate data = LocalDate.now();
	private String endereco;

	public LocadoraDto() {
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

	@Override
	public String toString() {
		return "LocadoraDto [cnpj=" + cnpj + ", senha=" + senha + ", data=" + data + ", endereco=" + endereco + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, data, endereco, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocadoraDto other = (LocadoraDto) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(data, other.data)
				&& Objects.equals(endereco, other.endereco) && senha == other.senha;
	}

}
