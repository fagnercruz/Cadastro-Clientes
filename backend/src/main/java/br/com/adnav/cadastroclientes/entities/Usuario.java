package br.com.adnav.Cadastroclientes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	private Long cpf;
	private Long identidade;
	private String expedidor;
	private String expedidorUf;
	private String telefone; 
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Usuario() {}

	

	public Usuario(Long id, String nome, int idade, Long cpf, Long identidade, String expedidor, String expedidorUf,
			String telefone, List<Endereco> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.identidade = identidade;
		this.expedidor = expedidor;
		this.expedidorUf = expedidorUf;
		this.telefone = telefone;
		this.enderecos = enderecos;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getIdentidade() {
		return identidade;
	}

	public void setIdentidade(Long identidade) {
		this.identidade = identidade;
	}

	public String getExpedidor() {
		return expedidor;
	}

	public void setExpedidor(String expedidor) {
		this.expedidor = expedidor;
	}

	public String getExpedidorUf() {
		return expedidorUf;
	}

	public void setExpedidorUf(String expedidorUf) {
		this.expedidorUf = expedidorUf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
}
