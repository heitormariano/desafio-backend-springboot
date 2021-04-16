package com.desafio.sistema.controller;

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

import com.desafio.sistema.model.Pessoa;
import com.desafio.sistema.repository.PessoaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PessoaController {

	private PessoaRepository repository;

	public PessoaController(PessoaRepository pessoaRespository) {
		this.repository = pessoaRespository;
	}

	@GetMapping("/pessoas")
	public List<Pessoa> getAllPessoas() {
		return repository.findAll();
	}

	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> findPessoaById(@PathVariable("id") Integer pessoaId) {
		return repository.findById(pessoaId).map(registro -> ResponseEntity.ok().body(registro))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/pessoas")
	public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
		return repository.save(pessoa);
	}

	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("id") Integer pessoaId, @RequestBody Pessoa pessoa) {
		return repository.findById(pessoaId).map(registro -> {
			registro.setNome(pessoa.getNome());
			registro.setSexo(pessoa.getSexo());
			registro.setEmail(pessoa.getEmail());
			registro.setDataNascimento(pessoa.getDataNascimento());
			registro.setNaturalidade(pessoa.getNaturalidade());
			registro.setNacionalidade(pessoa.getNacionalidade());
			registro.setCpf(pessoa.getCpf());

			Pessoa pAtualizado = repository.save(registro);
			return ResponseEntity.ok().body(pAtualizado);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/pessoas/{id}")
	public ResponseEntity<?> excluirPessoa(@PathVariable("id") Integer pessoaId) {
		return repository.findById(pessoaId).map(registro -> {
			repository.deleteById(pessoaId);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
