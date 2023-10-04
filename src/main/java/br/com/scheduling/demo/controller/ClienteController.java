package br.com.scheduling.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
import br.com.scheduling.demo.service.ClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
	
	
	private ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listClient() {
		return ResponseEntity.status(200).body(service.listClient());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> createClient(@RequestBody Cliente client) {
		return ResponseEntity.status(201).body(service.createClient(client));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente client) {
		return ResponseEntity.status(200).body(service.updateClient(client));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
		service.deleteClient(id);
		return ResponseEntity.status(204).build();
	}
	

}
