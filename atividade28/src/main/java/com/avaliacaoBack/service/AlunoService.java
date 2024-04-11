package com.avaliacaoBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaoBack.entitie.Aluno;
import com.avaliacaoBack.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository AlunoRepository;

	//construtor que recebe a dependencia
	@Autowired
	public AlunoService(AlunoRepository AlunoRepository) {
		this.AlunoRepository = AlunoRepository;
	}

	public List<Aluno> buscaTodosAluno(){
		return AlunoRepository.findAll();
	}

	public Aluno buscaAlunoId(Long id) {
		Optional <Aluno> Aluno = AlunoRepository.findById(id);
		return Aluno.orElse(null);
	}
	//query method
	public List<Aluno> buscarAlunosPorCidade(String cidade){
		return AlunoRepository.findByCidade(cidade);
	}
	//query method
	public List<Aluno> buscarAlunosPorNome(String nome){
		return AlunoRepository.findByNome(nome);
	}
	//query method
	public List<Aluno> buscarAlunosPorRenda(String renda){
		return AlunoRepository.findByRenda(renda);
	}
	//query method
	public List<Aluno> buscarAlunosPorRa(String ra){
		return AlunoRepository.findByRa(ra);
	}
	//query 2 methods
	public List<Aluno> buscarAlunosPorCidadeENome(String cidade, String nome){
		return AlunoRepository.findByCidadeAndNome(cidade, nome);
	}
	//metodo salvar os produtos
	public Aluno SalvaAluno(Aluno Aluno) {
		return AlunoRepository.save(Aluno);
	}
	public Aluno alterarAluno(Long id, Aluno alterarAluno) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);

		if (existeAluno.isPresent()) {
			alterarAluno.setId(id);
			return AlunoRepository.save(alterarAluno);
		}
		return null;
	}
	public boolean apagarAluno(Long id) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			AlunoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}



