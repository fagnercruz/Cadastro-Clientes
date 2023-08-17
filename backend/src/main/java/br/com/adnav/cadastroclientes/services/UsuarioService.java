package br.com.adnav.cadastroclientes.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adnav.cadastroclientes.dto.UsuarioDTO;
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
}
