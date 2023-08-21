package br.com.adnav.cadastroclientes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.adnav.cadastroclientes.dto.UsuarioDTO;
import br.com.adnav.cadastroclientes.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/all")
	public ResponseEntity<List<UsuarioDTO>> listarTodosUsuarios() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
		// Caso findById lançe um NoSuchElementException, será capturado pelo ControllerExceptionHandler
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<UsuarioDTO>> buscarUsuarioPorNome(@RequestParam String nome) {
		return ResponseEntity.ok(service.findByName(nome));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO dto) {
		UsuarioDTO dto2 = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto2.getId()).toUri();
		return ResponseEntity.created(uri).body(dto2);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
		UsuarioDTO dto2 = service.update(id, dto);
		return ResponseEntity.ok(dto2);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
