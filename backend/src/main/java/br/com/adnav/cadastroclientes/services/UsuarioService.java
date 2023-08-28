package br.com.adnav.cadastroclientes.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.adnav.cadastroclientes.dto.UsuarioDTO;
import br.com.adnav.cadastroclientes.entities.Usuario;
import br.com.adnav.cadastroclientes.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = repository.findAll();
		//List<Usuario> usuarios = repository.findAllWithEnderecos(usuarios);
		return usuarios.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) throws NoSuchElementException {
		Optional<Usuario> obj = repository.findById(id);
		Usuario usuario = obj.orElseThrow();
		return new UsuarioDTO(usuario);
	}

	@Transactional(readOnly = true)
	public List<UsuarioDTO> findByName(String nome) throws NoSuchElementException {
		List<Usuario> usuarios = repository.findByNomeContaining(nome);
		if(usuarios.isEmpty()) throw new NoSuchElementException("usuário não localizado");
		return usuarios.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
	}
	
	
	@Transactional
	public UsuarioDTO save(UsuarioDTO dto) {
		Usuario usuario = DTOToUserConverter(dto);
		return new UsuarioDTO(repository.save(usuario));
	}
	
	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			Usuario usuario = repository.getReferenceById(id);
			usuario = DTOToUserConverter(dto);
			usuario.setId(id); // Ajustar para que isso fique no método que copia os dados pois está sobrescrevendo o ID
			usuario = repository.save(usuario);
			return new UsuarioDTO(usuario);
		} catch (EntityNotFoundException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		// deleteById no Spring 3 não lança mais exception quando o id não existe, testar a existencia antes
		if(!repository.existsById(id)) {
			throw new NoSuchElementException("Id inexistente");
		}
		try {
			repository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new NoSuchElementException("Id inexistente");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Violação de Integridade: " + e.getMessage());
		}
	}
	
	// método util para copiar dados de um DTO para uma entidade
	private Usuario DTOToUserConverter(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		
		usuario.setNome(dto.getNome());
		usuario.setCEP(dto.getCEP());
		usuario.setEndereco(dto.getEndereco());
		return usuario;
	}
	
}
