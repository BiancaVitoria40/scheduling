package br.com.scheduling.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.scheduling.demo.entity.Cliente;
import br.com.scheduling.demo.repository.ICliente;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ICliente repository;
	
	
	@GetMapping
	public List<Cliente> listClient() {
		List<Cliente> list = (List<Cliente>)repository.findAll();
		return list;
	}
	
	@PostMapping
	public Cliente criarCliente(@RequestBody Cliente client) {
		Cliente clienteNew = repository.save(client);
		return clienteNew;
	}
	
	@PutMapping
	public Cliente updateCliente(@RequestBody Cliente client) {
		Cliente clienteNew = repository.save(client);
		return clienteNew;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Cliente> deleteCliente(@PathVariable Integer id) {
		Optional<Cliente> client = repository.findById(id);
		repository.deleteById(id);
		return client;
	}
	

}
