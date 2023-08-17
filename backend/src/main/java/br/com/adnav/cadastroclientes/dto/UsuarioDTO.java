package br.com.adnav.cadastroclientes.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.adnav.cadastroclientes.entities.Endereco;
import br.com.adnav.cadastroclientes.entities.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private Long cpf;
	private List<EnderecoDTO> enderecos = new ArrayList<>();
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, Long cpf, List<EnderecoDTO> enderecos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.enderecos = enderecos;
	}
	
	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		
		this.enderecos.clear();
		if(!entity.getEnderecos().isEmpty()) {
			for(Endereco end : entity.getEnderecos()) {
				this.enderecos.add(new EnderecoDTO(end));
			}
		}
	}
	
	public UsuarioDTO(Usuario entity, List<Endereco> enderecos) {
		this(entity);
		enderecos.forEach(endereco -> this.enderecos.add(new EnderecoDTO(endereco)));
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
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
