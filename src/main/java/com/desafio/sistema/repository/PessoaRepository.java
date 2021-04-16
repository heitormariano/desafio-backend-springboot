package com.desafio.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.sistema.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
