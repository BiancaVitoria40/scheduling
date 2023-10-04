package br.com.scheduling.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.scheduling.demo.entity.Cliente;
import br.com.scheduling.demo.repository.ICliente;

@Service
public class ClienteService {
	
	private ICliente repository;
	
	public ClienteService(ICliente repository) {
		this.repository = repository;
		
	}
	
	public List<Cliente> listClient(){
		List<Cliente> list = repository.findAll();
		return list;
		
	}
	
	public Cliente createClient(Cliente client){
		Cliente clienteNew = repository.save(client);
		return clienteNew;
		
	}
	
	public Cliente updateClient (Cliente client) {
		Cliente upClient = repository.save(client);
		return upClient;
	}
	
	public Boolean deleteClient(Integer id) {
		repository.deleteById(id);
		return true;
		
	}

}
