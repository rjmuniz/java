package br.com.munizes.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.munizes.Models.Estado;
import br.com.munizes.repositories.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	EstadoRepository estadoRepository;
	
	
	public Collection<Estado> BuscarTodos(){
		return estadoRepository.findAll();
	}
	
	public Estado BuscarId(int id) {
		return  estadoRepository.getOne(id);
	}
	
	public Estado cadastrar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void remover(Estado estado) {
		 estadoRepository.delete(estado);
	}
}
