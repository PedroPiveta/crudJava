package br.com.biopark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biopark.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
