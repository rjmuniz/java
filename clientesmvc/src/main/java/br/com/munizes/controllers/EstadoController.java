package br.com.munizes.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.munizes.Models.Estado;
import br.com.munizes.services.EstadoService;

@RestController
@RequestMapping(value="/private")
public class EstadoController {
	final String controllerName = "/estados";
	@Autowired
	EstadoService estadoService;

	@RequestMapping(method = RequestMethod.GET, value = controllerName, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Estado>> BuscarTodosApi() {
		Collection<Estado> estados = estadoService.BuscarTodos();
		return new ResponseEntity<>(estados, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = controllerName
			+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> BuscarIdApi(int id) {
		Estado estado = estadoService.BuscarId(id);
		return new ResponseEntity<>(estado, estado == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = controllerName, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> cadastrarApi(@RequestBody Estado estado) {
		Estado estadoCadastrado = estadoService.cadastrar(estado);

		return new ResponseEntity<>(estadoCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.DELETE, value=controllerName+"/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> DeleteApi(@PathVariable Integer id){
		Estado estado = estadoService.BuscarId(id);
		if(estado  == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		estadoService.remover(estado);
		return  new ResponseEntity<>(HttpStatus.OK);
	}

}
