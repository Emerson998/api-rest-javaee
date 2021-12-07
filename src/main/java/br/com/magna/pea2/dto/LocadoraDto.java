package br.com.magna.pea2.dto;

import java.time.LocalDate;

public class LocadoraDto {
	private Long cnpj;
	private String nomeDvd;
	private LocalDate data = LocalDate.now();
	private String endereco;

	public LocadoraDto() {
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeDvd() {
		return nomeDvd;
	}

	public void setNomeDvd(String nomeDvd) {
		this.nomeDvd = nomeDvd;
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
		return "LocadoraDto [cnpj=" + cnpj + ", nomeDvd=" + nomeDvd + ", data=" + data + ", endereco=" + endereco + "]";
	}
}
