package br.com.biopark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.models.Cliente;
import br.com.biopark.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository repository;
	
	public void save(Cliente cliente) {
		repository.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void update(Long id, Cliente cliente) {
		Cliente existingCliente = repository.findById(id).orElse(null);
        
        if (existingCliente == null) {
            return;
        }
        
        existingCliente.setNome(cliente.getNome());
        existingCliente.setEmail(cliente.getEmail());
        existingCliente.setCpf(cliente.getCpf());
        existingCliente.setTelefone(cliente.getTelefone());
        //existingCliente.setEndereco(cliente.getEndereco(null));
        
        repository.save(existingCliente);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
