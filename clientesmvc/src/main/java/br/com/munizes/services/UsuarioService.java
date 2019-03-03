package br.com.munizes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.munizes.Models.Usuario;
import br.com.munizes.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario buscarPorLogin(String login) {
		return usuarioRepository.buscarPorLogin(login);
	}
	
	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
