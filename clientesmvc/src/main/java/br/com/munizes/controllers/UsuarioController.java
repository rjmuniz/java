package br.com.munizes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.munizes.Models.Usuario;
import br.com.munizes.services.UsuarioService;


@RestController
@RequestMapping(value="/private")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadatrar(@RequestBody Usuario usuario) {
		Usuario cadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<Usuario>(cadastrado, HttpStatus.CREATED);
	}
}
