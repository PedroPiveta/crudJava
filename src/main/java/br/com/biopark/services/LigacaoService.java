package br.com.biopark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.models.Ligacao;
import br.com.biopark.repositories.LigacaoRepository;

@Service
public class LigacaoService {

    @Autowired
    LigacaoRepository repository;

    public void save(Ligacao ligacao) {
        repository.save(ligacao);
    }

    public List<Ligacao> findAll() {
        return repository.findAll();
    }

    public Ligacao findById(Long id) {
        return repository.findById(id).get();
    }

    public void update(Long id, Ligacao ligacao) {
        Ligacao existingLigacao = repository.findById(id).orElse(null);

        if (existingLigacao == null) {
            return;
        }

        existingLigacao.setDuracao(ligacao.getDuracao());
        existingLigacao.setDescricao(ligacao.getDescricao());
        existingLigacao.setHorario(ligacao.getHorario());

        repository.save(existingLigacao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
