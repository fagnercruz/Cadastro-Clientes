package br.com.adnav.cadastroclientes.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adnav.cadastroclientes.dto.EnderecoDTO;
import br.com.adnav.cadastroclientes.dto.UsuarioDTO;
import br.com.adnav.cadastroclientes.entities.Endereco;
import br.com.adnav.cadastroclientes.entities.Usuario;
import br.com.adnav.cadastroclientes.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = repository.findAll();
		//List<Usuario> usuarios = repository.findAllWithEnderecos(usuarios);
		return usuarios.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
	}
	
	public UsuarioDTO findById(Long id) throws NoSuchElementException {
		Optional<Usuario> obj = repository.findById(id);
		Usuario usuario = obj.orElseThrow();
		return new UsuarioDTO(usuario);
	}

	public List<UsuarioDTO> findByName(String nome) throws NoSuchElementException {
		List<Usuario> usuarios = repository.findByNomeContaining(nome);
		if(usuarios.isEmpty()) throw new NoSuchElementException("usuário não localizado");
		return usuarios.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
	}
	
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		Usuario usuario = DTOToUserConverter(usuarioDTO);
		return new UsuarioDTO(repository.save(usuario));
	}
	
	private Usuario DTOToUserConverter(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		
		
		//copy attributes of dto to entity
		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setCpf(dto.getCpf());
		
		//copy address of dto to entity
		usuario.getEnderecos().clear();
		for(EnderecoDTO endDto : dto.getEnderecos()) {
			Endereco endereco = new Endereco();
			endereco.setId(endDto.getId());
			endereco.setCep(endDto.getCep());
			endereco.setLogradouro(endDto.getLogradouro());
			endereco.setCidade(endDto.getCidade());
			
			usuario.getEnderecos().add(endereco);
		}
	
		return usuario;

	
	}
}
