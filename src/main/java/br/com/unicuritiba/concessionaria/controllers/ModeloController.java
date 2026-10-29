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

import br.com.unicuritiba.concessionaria.models.Modelo;
import br.com.unicuritiba.concessionaria.repositories.ModeloRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/modelo")
public class ModeloController {

    final ModeloRepository repository;

    public ModeloController(ModeloRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> getAllModelos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModeloById(
            @PathVariable long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Modelo> saveModelo(
            @RequestBody Modelo modelo) {

        Modelo savedModelo = repository.save(modelo);

        return ResponseEntity.ok(savedModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(
            @PathVariable long id,
            @RequestBody Modelo modelo) {

        modelo.setId(id);

        Modelo savedModelo = repository.save(modelo);

        return ResponseEntity.ok(savedModelo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeModelo(
            @PathVariable long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}