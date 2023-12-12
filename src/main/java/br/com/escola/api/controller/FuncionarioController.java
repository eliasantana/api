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

import br.com.escola.api.dto.FuncionarioDto;
import br.com.escola.api.services.FuncionarioServices;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioServices funcionarioServices;

	@PostMapping()
	public ResponseEntity<FuncionarioDto> creteFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {
		FuncionarioDto funcionarioDtoSalvo = this.funcionarioServices.createFuncionario(funcionarioDto);
		return new ResponseEntity<>(funcionarioDtoSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<FuncionarioDto>> getAllFuncionario() {
		List<FuncionarioDto> listaFuncionarioDto =  this.funcionarioServices.listarTodosFuncionarios();
		return new ResponseEntity<> (listaFuncionarioDto, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<FuncionarioDto> funcionarioPorId(@PathVariable("id") @Valid Long id) {
		FuncionarioDto funcionarioDto = this.funcionarioServices.funcionarioPorId(id);
		return new ResponseEntity<>(funcionarioDto, HttpStatus.OK);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<FuncionarioDto> atualisaFuncionario(@RequestBody FuncionarioDto funcionarioDto, @PathVariable  @Valid Long id) {
		FuncionarioDto funcionarioDtoAtualizado = this.funcionarioServices.atualizaFuncionario(funcionarioDto, id);
		return new ResponseEntity<>(funcionarioDtoAtualizado, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<List<FuncionarioDto>> deleteFuncionario(@PathVariable("id") @Valid Long id) {
		List<FuncionarioDto> funcionarioDto = this.funcionarioServices.deletaFuncionario(id);
		return new ResponseEntity<>(funcionarioDto, HttpStatus.OK);
	}
}
