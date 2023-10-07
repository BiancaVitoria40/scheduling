package br.com.scheduling.demo.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.scheduling.demo.entity.Cliente;
import br.com.scheduling.demo.repository.ICliente;


@Service
public class ClienteService {
	
	private ICliente repository;
	private PasswordEncoder passwordEncoder;
	
	public ClienteService(ICliente repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
		
	}
	
	public List<Cliente> listClient(){
		List<Cliente> list = repository.findAll();
		return list;
		
	}
	
	public Cliente createClient(Cliente client){
		String encoder = this.passwordEncoder.encode(client.getSenha());
		client.setSenha(encoder);
		Cliente clienteNew = repository.save(client);
		return clienteNew;
		
	}
	
	public Cliente updateClient (Cliente client) {
		String encoder = this.passwordEncoder.encode(client.getSenha());
		client.setSenha(encoder);
		Cliente upClient = repository.save(client);
		return upClient;
	}
	
	public Boolean deleteClient(Integer id) {
		repository.deleteById(id);
		return true;
		
	}

	public Boolean validarSenha(Cliente client) {
		String senha = repository.getById(client.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(client.getSenha(), senha);
		return valid;
	}

}
