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

import br.com.munizes.Models.Cliente;
import br.com.munizes.services.ClienteService;

@RestController
@RequestMapping(value ="/private")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarApi(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);

		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosApi() {
		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();

		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarIdApi(@PathVariable Integer id) {
		Cliente clientesBuscados = clienteService.buscarId(id);

		return new ResponseEntity<>(clientesBuscados, clientesBuscados == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarApi(@PathVariable Integer id) {
		Cliente clienteEncontrado = clienteService.buscarId(id);
		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(clienteEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clientes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarApi(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Cliente clienteAlterado = clienteService.alterar(id, cliente);

		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	}
}
