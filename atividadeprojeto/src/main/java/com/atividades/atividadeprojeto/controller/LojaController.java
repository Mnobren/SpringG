package com.atividades.atividadeprojeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.atividades.atividadeprojeto.model.Loja;
import com.atividades.atividadeprojeto.repository.LojaRepository;

@RestController
@RequestMapping ("/loja")
@CrossOrigin ("*")
public class LojaController 
{
	@Autowired
	private LojaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Loja>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Loja> GetById(@PathVariable long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Loja> Post(@RequestBody Loja loja)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(loja));
	}
	
	@PutMapping
	public ResponseEntity<Loja> Put(@RequestBody Loja loja)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(loja));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id)
	{
		repository.deleteById(id);
	}
}