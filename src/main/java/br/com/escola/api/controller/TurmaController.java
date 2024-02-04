package br.com.escola.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.escola.api.dto.TurmaDto;
import br.com.escola.api.services.TurmaServices;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	TurmaServices turmaService;

	
	@GetMapping("/listar")
	public ResponseEntity<List<TurmaDto>> listaDeTurmas() {
		List<TurmaDto>  listaDto = this.turmaService.listaDeTurmas();
		
		return new ResponseEntity<> (listaDto, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{cdTurma}")
	public ResponseEntity<TurmaDto> localizarTurma(@RequestBody @PathVariable @Valid Long cdTurma) {
		TurmaDto turmaDto = this.turmaService.localizarTurma(cdTurma);
		
		return new ResponseEntity<> (turmaDto, HttpStatus.OK);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<TurmaDto> cadastrarTurma(@RequestBody @Valid TurmaDto turmaDto) {
		TurmaDto turmaCadastrada =  this.turmaService.cadastrarTurma(turmaDto);
		return new ResponseEntity<>(turmaCadastrada, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletar/{cdTurma}")
	public ResponseEntity<TurmaDto> deletaTurma(@PathVariable @Valid Long cdTurma) {
		this.turmaService.deletaTurma(cdTurma);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/atualizar/{cdTurma}")
	public ResponseEntity<TurmaDto> atualizarTurma(@RequestBody @Valid TurmaDto turmaDto, @PathVariable Long cdTurma) {
		TurmaDto turmaAtualizada = this.turmaService.atualizarTurma(turmaDto, cdTurma);
				return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
	}
}
