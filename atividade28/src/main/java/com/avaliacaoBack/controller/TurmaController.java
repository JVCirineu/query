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
import com.avaliacaoBack.entitie.Turma;
import com.avaliacaoBack.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	private final TurmaService TurmaService;

	@Autowired
	public TurmaController(TurmaService TurmaService) {
		this.TurmaService = TurmaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscaTurmaControlId(@PathVariable Long id){
		Turma Turma = TurmaService.buscaTurmaId(id);
		if (Turma != null) {
			return ResponseEntity.ok(Turma);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Turma>> buscaTodosTurmaControl(){
		List<Turma> Turma = TurmaService.buscaTodosTurma();

		return ResponseEntity.ok(Turma);
	}
	//query method
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Turma>> buscarTurmaPorNome(@PathVariable String nome){
		List<Turma> turma = TurmaService.buscarTurmaPorNome(nome);
		return ResponseEntity.ok(turma);
	}
	//query method
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Turma>> buscarTurmaPorDescricao(@PathVariable String descricao){
		List<Turma> turma = TurmaService.buscarTurmaPorDescricao(descricao);
		return ResponseEntity.ok(turma);
	}
	//query methods 2
	@GetMapping("/cidade/{cidade}/nome/{nome}")
	public ResponseEntity<List<Turma>> buscarTurmaPorNomeEDescricao(@PathVariable String nome, String descricao){
		List<Turma> turma = TurmaService.buscarTurmaPorNomeEDescricao(nome, descricao);
		return ResponseEntity.ok(turma);
	}
	@PostMapping("/")
	public ResponseEntity<Turma> salvaTurmaControl(@RequestBody Turma Turma){
		Turma salvaTurma = TurmaService.SalvaTurma(Turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Turma> alterarTurmaControl(@PathVariable Long id, @RequestBody Turma Turma){
		Turma alterarTurma = TurmaService.alterarTurma(id, Turma);
		if(Turma != null) {
			return ResponseEntity.ok(Turma);
		}
		else {
			return ResponseEntity.notFound().build();   	
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaTurmaControl(@PathVariable Long id){
		boolean apagar = TurmaService.apagarTurma(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Turma foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}


