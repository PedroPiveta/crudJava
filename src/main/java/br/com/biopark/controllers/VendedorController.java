package br.com.biopark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biopark.models.Vendedor;
import br.com.biopark.services.VendedorService;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {
	
	@Autowired
	VendedorService service;
	
	@GetMapping
	public List<Vendedor> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Vendedor findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Vendedor vendedor) {
		service.save(vendedor);
		return ResponseEntity.ok("Vendedor salvo");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Vendedor vendedor){
		service.update(id, vendedor);
		
		return ResponseEntity.ok("Vendedor alterado com sucesso");
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		
		return ResponseEntity.ok("Vendedor apagado com sucesso");
	}
}
