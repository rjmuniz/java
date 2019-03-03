package br.com.munizes.controllers;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.munizes.Models.Usuario;
import br.com.munizes.services.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping(value = "/public")
public class LoginController {
	@Autowired
	UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {
		if (usuario == null || usuario.getLogin() ==null || usuario.getSenha() == null)
			throw new ServletException("Nome e senha obrigatórios");
		
		Usuario found = usuarioService.buscarPorLogin(usuario.getLogin());
		
		if(found == null)
			throw new ServletException("Usuario não encontrado");
		
		if(!usuario.getSenha().equals(found.getSenha()))
			throw new ServletException("O usuário ou senha não confere");
		
		String token = Jwts
				.builder()
				.setSubject(usuario.getLogin())
				.claim("Senha", usuario.getSenha())
				.claim("Valor", 123)
				.signWith(SignatureAlgorithm.HS512, "rjmj")
				.setExpiration(new Date(System.currentTimeMillis()+(2*60*1000)))
				.compact();
		
		
		return new LoginResponse(token);
	}
	
	
	private class LoginResponse{
		@SuppressWarnings("unused")
		public String token;
		public LoginResponse(String _token) {
			token = _token;
		}		
	}
}
