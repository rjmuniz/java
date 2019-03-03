package br.com.munizes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.munizes.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query(value="select u from Usuario u where u.login = :plogin"  )
	public Usuario buscarPorLogin(@Param("plogin") String login);
}
