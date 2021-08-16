package br.com.carlosFelipe.entrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import br.com.carlosFelipe.entrega.model.Aluno;
import br.com.carlosFelipe.entrega.repository.AlunoRepository;
import br.com.carlosFelipe.entrega.service.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	AlunoService alunoService;

	@PostMapping(value = "/aluno", consumes = "multipart/form-data")
	public ResponseEntity<Aluno> adicionar(@RequestParam("file") MultipartFile file[],
			@RequestParam("matricula") Long matricula, @RequestParam("name") String name) {

		try {
			return new ResponseEntity<Aluno>(alunoService.adicionarAluno(file, matricula, name), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@GetMapping("/alunos")
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

	@GetMapping
	public ResponseEntity<Aluno> buscar(@PathVariable Long alunoId) {
		return alunoRepository.findById(alunoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
