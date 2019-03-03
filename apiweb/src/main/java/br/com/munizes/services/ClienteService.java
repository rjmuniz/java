package br.com.munizes.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.munizes.Models.Cliente;
import br.com.munizes.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Collection<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscarId(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.isEmpty()? null: cliente.get();
	}
	
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public Cliente alterar(Integer id, Cliente cliente) {
		cliente.setId(id);
		return clienteRepository.save(cliente);
	}
}
