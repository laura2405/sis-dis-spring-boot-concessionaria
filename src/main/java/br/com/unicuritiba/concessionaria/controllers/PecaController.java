package br.com.unicuritiba.concessionaria.controllers;

import java.util.List;

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

import br.com.unicuritiba.concessionaria.models.Peca;
import br.com.unicuritiba.concessionaria.repositories.PecaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/peca")
public class PecaController {

    final PecaRepository repository;

    public PecaController(PecaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Peca>> getAllPecas() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> getPecaById(
            @PathVariable long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Peca> savePeca(
            @RequestBody Peca peca) {

        Peca savedPeca = repository.save(peca);

        return ResponseEntity.ok(savedPeca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peca> updatePeca(
            @PathVariable long id,
            @RequestBody Peca peca) {

        peca.setId(id);

        Peca savedPeca = repository.save(peca);

        return ResponseEntity.ok(savedPeca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePeca(
            @PathVariable long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}