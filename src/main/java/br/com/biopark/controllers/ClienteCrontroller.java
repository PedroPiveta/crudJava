package br.com.biopark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.biopark.models.Cliente;
import br.com.biopark.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteCrontroller {
	@Autowired
	ClienteService service;
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping
	public List<Cliente> findAll() {
		return service.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/{id}")
	public Cliente findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		service.save(cliente);
		return ResponseEntity.ok("Cliente salvo");
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente){
		service.update(id, cliente);
		
		return ResponseEntity.ok("Cliente alterado com sucesso");
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		
		return ResponseEntity.ok("Cliente apagado com sucesso");
	}
}
