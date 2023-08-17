package br.com.adnav.cadastroclientes.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	public void salvarUsuario() {
		
	}
	
	public void excluirUsuario() {
		
	}
	
	
}
