package br.com.scheduling.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheduling.demo.entity.Cliente;
import br.com.scheduling.demo.service.ClienteService;
import jakarta.validation.Valid;

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
	public ResponseEntity<Cliente> createClient(@Valid @RequestBody Cliente client) {
		return ResponseEntity.status(201).body(service.createClient(client));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> updateCliente(@Valid @RequestBody Cliente client) {
		return ResponseEntity.status(200).body(service.updateClient(client));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
		service.deleteClient(id);
		return ResponseEntity.status(204).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Cliente> validarSenha(@Valid @RequestBody Cliente client){
		Boolean valid = service.validarSenha(client);
		if(!valid) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.status(200).build();
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			
			errors.put(fieldName, errorMessage);
			
		});
		return errors;
		
	}
	

	

}
