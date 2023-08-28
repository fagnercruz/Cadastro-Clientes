package br.com.adnav.cadastroclientes.dto;

import java.util.Objects;

import br.com.adnav.cadastroclientes.entities.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String CEP;
	private String endereco;
	
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, Long cpf, String cep, String endereco, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.CEP = cep;
		this.endereco = endereco;
	}

	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.CEP = entity.getCEP();
		this.endereco = entity.getEndereco();
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

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}
	
}
