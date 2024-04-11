package com.avaliacaoBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoBack.entitie.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long>{
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByNome(String nome);
	List<Aluno> findByRenda(String renda);
	List<Aluno> findByRa(String ra);
	List<Aluno>findByCidadeAndNome(String cidade, String nome);
}
