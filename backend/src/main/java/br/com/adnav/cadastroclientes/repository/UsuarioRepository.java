package br.com.adnav.cadastroclientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.adnav.cadastroclientes.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//Abordagem para trazer os usuários com os endereços caso não queira usar o fetchtype=EAGER
	@Query("SELECT u FROM Usuario u JOIN FETCH u.enderecos WHERE u IN :usuarios")
	List<Usuario> findAllWithEnderecos(List<Usuario> usuarios);

	@Query(value = "SELECT u FROM Usuario u WHERE u.nome ILIKE %:nome%")
	List<Usuario> findByNomeContaining(String nome);
}
