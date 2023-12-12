package br.com.escola.api.model;

import java.time.LocalDateTime;

import br.com.escola.api.dto.FuncionarioDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdFuncionario;
	private String nome;
	private LocalDateTime dtCadastro;
	private String cpf;
	
	public Funcionario() {	
	}
	
	public Funcionario(FuncionarioDto funcionarioDto) {
		this.cdFuncionario = funcionarioDto.getCdFuncionario();
		this.nome = funcionarioDto.getNome();
		if(funcionarioDto.getDtCadastro() != null) {
			this.dtCadastro = funcionarioDto.getDtCadastro();
		} else {
			this.dtCadastro = LocalDateTime.now();
		}
		
		this.cpf = funcionarioDto.getCpf();
	}

	public Funcionario(Long cdFuncionario, String nome, LocalDateTime dtCadastro, String cpf) {
		this.cdFuncionario = cdFuncionario;
		this.nome = nome;
		this.dtCadastro = dtCadastro;
		this.cpf = cpf;
	}

	public Long getCdFuncionario() {
		return cdFuncionario;
	}

	public void setCdFuncionario(Long cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	

}
