package br.com.biopark.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biopark.models.Cliente;
import br.com.biopark.models.Vendedor;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

