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

import br.com.biopark.models.Ligacao;
import br.com.biopark.services.LigacaoService;

@RestController
@RequestMapping("/api/ligacao")
public class LigacaoController {

    @Autowired
    LigacaoService service;

    @GetMapping
    public List<Ligacao> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Ligacao findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Ligacao ligacao) {
        service.save(ligacao);
        return ResponseEntity.ok("ligação salva");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Ligacao ligacao){
        service.update(id, ligacao);

        return ResponseEntity.ok("Ligação alterada com sucesso");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);

        return ResponseEntity.ok("Ligação apagada com sucesso");
    }
}
