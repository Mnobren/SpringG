package com.lojajogos.atividadeloja.controller;

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

import com.lojajogos.atividadeloja.model.Categoria;
import com.lojajogos.atividadeloja.model.Desenvolvedor;
import com.lojajogos.atividadeloja.repository.DesenvolvedorRepository;

@RestController
@RequestMapping ("/desenvolvedor")
@CrossOrigin ("*")
public class DesenvolvedorController
{
	@Autowired
	private DesenvolvedorRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Desenvolvedor>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Desenvolvedor> GetById(@PathVariable long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String descricao)
	{
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Desenvolvedor> Post(@RequestBody Desenvolvedor desenvolvedor)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(desenvolvedor));
	}
	
	@PutMapping
	public ResponseEntity<Desenvolvedor> Put(@RequestBody Desenvolvedor desenvolvedor)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(desenvolvedor));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id)
	{
		repository.deleteById(id);
	}
}