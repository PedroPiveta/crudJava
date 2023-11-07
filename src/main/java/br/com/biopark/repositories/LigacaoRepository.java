package br.com.biopark.repositories;

import br.com.biopark.models.Ligacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigacaoRepository extends JpaRepository<Ligacao, Long> {

}
