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

import br.com.unicuritiba.concessionaria.models.Plataforma;
import br.com.unicuritiba.concessionaria.repositories.PlataformaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/plataforma")
public class PlataformaController {

	final PlataformaRepository repository;

	PlataformaController(PlataformaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public ResponseEntity<List<Plataforma>> 
			getAllPlataformas(){
		return ResponseEntity
				.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plataforma> 
			getPlataformaById(@PathVariable long id){
		return ResponseEntity
				.ok(repository.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Plataforma> savePlataforma(
			@RequestBody Plataforma plataforma){
		Plataforma savedPlataforma = 
				repository.save(plataforma);
		return ResponseEntity.ok(savedPlataforma);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Plataforma> updatePlataforma(
			@PathVariable long id, 
			@RequestBody Plataforma plataforma){
		plataforma.setId(id);
		Plataforma savedPlataforma = 
				repository.save(plataforma);
		return ResponseEntity.ok(savedPlataforma);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Plataforma> removePlataforma(
			@PathVariable long id){
				repository.deleteById(id);
		return ResponseEntity.ok(null);
	}
}
