package br.com.adnav.cadastroclientes.dto;

import java.util.Objects;

import br.com.adnav.cadastroclientes.entities.Endereco;

public class EnderecoDTO {
	
	private Long id;
	private String cep;
	private String logradouro;
	private String cidade;

	public EnderecoDTO() {}

	public EnderecoDTO(Long id, String cep, String logradouro, String cidade) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
	}
	
	public EnderecoDTO(Endereco entity) {
		this.id = entity.getId();
		this.cep = entity.getCep();
		this.logradouro = entity.getLogradouro();
		this.cidade = entity.getCidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
