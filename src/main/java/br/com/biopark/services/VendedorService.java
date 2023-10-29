package br.com.biopark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.models.Vendedor;
import br.com.biopark.repositories.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	VendedorRepository repository;
	
	public void save(Vendedor vendedor) {
		repository.save(vendedor);
	}
	
	public List<Vendedor> findAll() {
		return repository.findAll();
	}
	
	public Vendedor findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void update(Long id, Vendedor vendedor) {
		Vendedor existingVendedor = repository.findById(id).orElse(null);
        
        if (existingVendedor == null) {
            return;
        }
        
        existingVendedor.setNome(vendedor.getNome());
        existingVendedor.setEmail(vendedor.getEmail());
        existingVendedor.setMeta(vendedor.getMeta());
        
        repository.save(existingVendedor);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
