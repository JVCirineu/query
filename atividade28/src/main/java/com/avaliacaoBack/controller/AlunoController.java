package com.avaliacaoBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacaoBack.entitie.Aluno;
import com.avaliacaoBack.service.AlunoService;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
	private final AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id){
		Aluno aluno = alunoService.buscaAlunoId(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<Aluno>> buscaTodosAlunoControl(){
		List<Aluno> aluno = alunoService.buscaTodosAluno();

		return ResponseEntity.ok(aluno);
	}
	//query method
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade){
		List<Aluno> alunos = alunoService.buscarAlunosPorCidade(cidade);
		return ResponseEntity.ok(alunos);
	}
	//query method
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome){
		List<Aluno> alunos = alunoService.buscarAlunosPorNome(nome);
		return ResponseEntity.ok(alunos);
	}
	//query method
	@GetMapping("/renda/{renda}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorRenda(@PathVariable String renda){
		List<Aluno> alunos = alunoService.buscarAlunosPorRenda(renda);
		return ResponseEntity.ok(alunos);
	}
	//query method
	@GetMapping("/renda/{renda}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorRa(@PathVariable String ra){
		List<Aluno> alunos = alunoService.buscarAlunosPorRenda(ra);
		return ResponseEntity.ok(alunos);
	}
	//query methods 2
	@GetMapping("/cidade/{cidade}/nome/{nome}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorCidadeENome(@PathVariable String cidade, String nome){
		List<Aluno> alunos = alunoService.buscarAlunosPorCidadeENome(cidade, nome);
		return ResponseEntity.ok(alunos);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody Aluno aluno){
		Aluno salvaAluno = alunoService.SalvaAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterarAlunoControl(@PathVariable Long id, @RequestBody Aluno aluno){
		Aluno alterarAluno = alunoService.alterarAluno(id, aluno);
		if(aluno != null) {
			return ResponseEntity.ok(aluno);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){
		boolean apagar = alunoService.apagarAluno(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Aluno foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}


